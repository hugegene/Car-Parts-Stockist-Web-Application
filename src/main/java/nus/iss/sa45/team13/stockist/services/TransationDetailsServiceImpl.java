package nus.iss.sa45.team13.stockist.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import nus.iss.sa45.team13.stockist.model.TransationDetails;
import nus.iss.sa45.team13.stockist.repository.TransationDetailsRepository;

@PropertySource({ "classpath:application.properties",
"classpath:/i18n/messages.properties" })
@Service
public class TransationDetailsServiceImpl implements TransationDetailsService {

	@Resource
	private Environment env;
	
	@Autowired
	TransationDetailsRepository transationDetailsrepository;
	
	@Override
	public ArrayList<TransationDetails> findAll() {
		ArrayList<TransationDetails> tran = (ArrayList<TransationDetails>)transationDetailsrepository.findAll();
		return tran;
	}


	


	@Override
	public TransationDetails newTrandetails(TransationDetails t) {
		final String PROPERTY_NAME_DATABASE_URL = "db.url";
		final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
		final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
		
		//Composite key issues, so we're going with the old fashioned way here.
		try {
			Connection con = DriverManager.getConnection(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL), env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME), env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
			java.sql.PreparedStatement stmt = con.prepareStatement("Insert into sa45grp13ca.transactiondetails values (?, ?, ?)");
			stmt.setInt(1, t.getTransid());
			stmt.setInt(2, t.getPartnumber());
			stmt.setInt(3, t.getQty());
			
			System.out.println("XXX This did a insert of : " + stmt.executeUpdate());
			
			stmt.close();
			con.close();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
