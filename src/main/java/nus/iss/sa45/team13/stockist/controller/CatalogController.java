package nus.iss.sa45.team13.stockist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;
import nus.iss.sa45.team13.stockist.model.Product;
import nus.iss.sa45.team13.stockist.services.CatalogService;
import nus.iss.sa45.team13.stockist.services.LocalInventoryListService;


@Controller
@Secured({"ROLE_ADMIN","ROLE_STAFF"})
public class CatalogController {
	
	
	
	@Autowired
	private CatalogService cService;
	@Autowired
	private LocalInventoryListService iService;
	
	@RequestMapping(value= {"/catalog"}, method = RequestMethod.GET)
	public ModelAndView CatalogPage(HttpSession httpSession){
		
		Product product = new Product();
		ArrayList<Product> catalog = cService.findAllProducts();
		ArrayList<LocalinventoryList> inventoryList = (ArrayList<LocalinventoryList>)iService.findAll();
		ModelAndView mav = new ModelAndView("catalogpage", "product", product);
		mav.addObject("catalog", catalog);
		mav.addObject("inventoryList", inventoryList);
		if(httpSession.getAttribute("saved") != null) {
			System.out.println("CatalogSesson found" + httpSession.getAttribute("saved").toString());
			Integer count = ((Map)httpSession.getAttribute("saved")).size();
			mav.addObject("sessionData", count);
		}
		else {
			System.out.println("empty");
			mav.addObject("sessionData", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/catalog", method = RequestMethod.POST)
	public ModelAndView RefinedCatalogPage(@ModelAttribute Product product, BindingResult result, HttpSession httpSession) {

//		if (result.hasErrors())
//			return new ModelAndView("department-new");
		try {
			product.setPartNumber(Integer.parseInt(product.getPartName()));
		}
		catch(Exception e) {
			product.setPartNumber(-1);
		}
		System.out.println("product found" + product.toString());
		//ArrayList<Product> catalog = new ArrayList<Product>();
		ArrayList<Product> catalog= cService.findByName(product.getPartName());
		System.out.println(product.getPartName());
		ArrayList<Product> catalog2= cService.findByNumber(product.getPartNumber());
		catalog.addAll(catalog2);
		//Product p= cService.findOne(product.getPartNumber());
		
		//catalog.add(p);
		
		ModelAndView mav = new ModelAndView("catalogpage", "catalog", catalog);
		return mav;
	}
	
	

	
	
}
