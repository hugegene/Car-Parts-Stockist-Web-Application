package nus.iss.sa45.team13.stockist.controller;

import java.util.*;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;
import nus.iss.sa45.team13.stockist.model.Product;
import nus.iss.sa45.team13.stockist.model.Transation;
import nus.iss.sa45.team13.stockist.model.TransationDetails;
import nus.iss.sa45.team13.stockist.model.User;
import nus.iss.sa45.team13.stockist.repository.TransationRepository;
import nus.iss.sa45.team13.stockist.repository.UserRepository;
import nus.iss.sa45.team13.stockist.services.LocalInventoryListService;
import nus.iss.sa45.team13.stockist.services.ProductService;
import nus.iss.sa45.team13.stockist.services.TransationDetailsService;
import nus.iss.sa45.team13.stockist.services.TransationService;
import nus.iss.sa45.team13.stockist.validators.SuppliersValidator;
import nus.iss.sa45.team13.stockist.validators.TransationValidator;

@Controller
@Secured({"ROLE_ADMIN","ROLE_STAFF"})
public class TransationController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	private TransationService tranService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TransationDetailsService detailsService;
	@Autowired
	private LocalInventoryListService localService;

	
	
	
	@RequestMapping(value = "/translist", method = RequestMethod.GET)
	public ModelAndView tranListPage(HttpSession httpSession) {

		
		ArrayList<Product> productlist = new ArrayList<Product>();
		ArrayList<Integer> qtylist = new ArrayList<Integer>();

		ModelAndView mav = new ModelAndView("translist");

		try {
			Map saved = (Map) httpSession.getAttribute("saved");

			Set set = saved.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry) iterator.next();
				System.out.print("partnumber is " + mentry.getKey() + "qty is ");
				System.out.println(mentry.getValue());
				Product pp = productService.findOne((int) mentry.getKey());
				productlist.add(pp);
				qtylist.add((Integer) mentry.getValue());

			}
			mav.addObject("productlist", productlist);
			mav.addObject("qtyist", qtylist);
		} catch (Exception e) {

			System.out.println("EEEException: " + e.toString());
			httpSession.removeAttribute("saved");
			mav.setViewName("redirect:/catalog");
		}
		// To get user id first get logged in name
		// User currUser;
		// try {
		// currUser = userRepo.findUserByUserId(
		// SecurityContextHolder.getContext().getAuthentication().getName()
		// );
		// }
		// catch (Exception e) {
		// currUser = new User();
		// }
		//
		// //And the ID it
		// Integer loggedInId = currUser.getStaffId();
		// mav.addObject("currUser",currUser);
		return mav;
	}

	@RequestMapping(value = "/translist", method = RequestMethod.POST)
	public ModelAndView newTranRrecordPage(HttpSession httpSession, @ModelAttribute Transation trans,
			BindingResult result, final RedirectAttributes redirectAttributes) {

			Map saved = (Map) httpSession.getAttribute("saved");
		try {
			/*
			 * User currUser; try { currUser = userRepo.findUserByUserId(
			 * SecurityContextHolder.getContext().getAuthentication().getName() ); } catch
			 * (Exception e) { currUser = new User(); }
			 * 
			 * //And the ID it Integer loggedInId = currUser.getStaffId();
			 */
			System.out.println("Something");
			Date d = new Date();

			Transation transation = new Transation();
			transation.setStaffid(2);
			transation.setDatetime(d);
			transation.setLicenseplateno("GZ2421L");
			transation.setRemarks("Something");
			tranService.newTranRrecordPage(transation);

			// Adding to Tran Details
			ArrayList<Transation> submitTranList = tranService.findAll();
			Transation submitTran = submitTranList.get(submitTranList.size() - 1);
			int tranId = submitTran.getTransid();

			

			Set set = saved.entrySet();
			Iterator iterator = set.iterator();

			while (iterator.hasNext()) {
				if (result.hasErrors())
					return new ModelAndView("translist");
				Map.Entry mentry = (Map.Entry) iterator.next();

				TransationDetails detail = new TransationDetails();

				detail.setTransid(tranId);
				detail.setPartnumber((int) mentry.getKey());
				detail.setQty((int) mentry.getValue());
				detailsService.newTrandetails(detail);

				LocalinventoryList localinventory = localService.findOne((int) mentry.getKey());
				System.out.println(localinventory.getStoreqty());
				localinventory.setStoreqty((int) localinventory.getStoreqty() - (int) mentry.getValue());
				System.out.println(localinventory.getStoreqty());
				// localinventory.setStoreqty(newqty);
				localService.reduceQty(localinventory);

			}
		} catch (Exception e) {

			System.out.println("EEEEException: " + e.toString());
		} finally {
			saved.clear();
			
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/catalog");

		return mav;
	}

	
	@RequestMapping(value = "/translist/cancel", method = RequestMethod.POST)
	public ModelAndView returnToCatalog(HttpSession httpSession ) {
	
		try {
			Map saved = (Map) httpSession.getAttribute("saved");
			saved.clear();
		}catch(Exception e) {
			
			System.out.println("EEE session wrong here" + e.getMessage());
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/catalog");
		return mav;
	}

}
