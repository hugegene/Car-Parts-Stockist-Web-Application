package nus.iss.sa45.team13.stockist.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Secured("ROLE_ADMIN")
//@RequestMapping(value = "/admin/")
@Controller
public class ReportController {
	

	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	@ResponseBody
	public void generateReport(HttpServletResponse response) throws JRException, SQLException, IOException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa45grp13ca?useSSL=false", "root", "password");
		
		//start - getting the file path
		ClassLoader classLoader = getClass().getClassLoader();
		String inputFileLocation = new File(classLoader.getResource("ReorderReport.jrxml").getFile()).getAbsolutePath().toString();
		inputFileLocation = URLDecoder.decode(inputFileLocation, "UTF-8");
		System.out.println("Opening Jasper File : " + inputFileLocation);
		//end - file path
		
		//start - loading the JRXML into a JasperReport object
		JasperDesign reorderReportStream = JRXmlLoader.load(inputFileLocation);
		Map<String,Object> params = new HashMap<>();
		JasperReport jasperReport = JasperCompileManager.compileReport(reorderReportStream);
		//end - loading
		
		//start - fill data
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn);
		//end - fill data
		
		//prepare and put it into pdf file
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=reorderReport.pdf");
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
}