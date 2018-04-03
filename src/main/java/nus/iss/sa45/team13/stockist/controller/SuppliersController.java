package nus.iss.sa45.team13.stockist.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.sa45.team13.stockist.model.Suppliers;
import nus.iss.sa45.team13.stockist.services.SuppliersService;
import nus.iss.sa45.team13.stockist.validators.SuppliersValidator;

//@Secured("ROLE_ADMIN")
@RequestMapping(value = "/admin/suppliers")
@Controller
public class SuppliersController {

	@Autowired
	SuppliersService sservice;

	@Autowired
	private SuppliersValidator sValidator;

	@InitBinder("suppliers")
	private void initSuppliersBinder(WebDataBinder binder) {
		binder.setValidator(sValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView suppliersListPage() {
		ModelAndView mav = new ModelAndView("suppliers-list");
		ArrayList<Suppliers> supplierList = (ArrayList<Suppliers>) sservice.findAllSuppliers();
		mav.addObject("supplierList", supplierList);

		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		Suppliers s = new Suppliers();
		ModelAndView mav = new ModelAndView("supplier-new", "suppliers", s);
		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute @Valid Suppliers supplier, BindingResult result,
			final RedirectAttributes redirattr) {

		if (result.hasErrors())
			return new ModelAndView("supplier-new");

		ModelAndView mav = new ModelAndView();
		sservice.createSupplier(supplier);

		String message = "New Student " + supplier.getSupplierid() + ", " + supplier.getName() + " has been created.";
		mav.setViewName("redirect:/admin/suppliers/list");
		redirattr.addFlashAttribute("message", message);
		return mav;

	}

	@RequestMapping(value = "/edit/{supplierid}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable String supplierid) {
		ModelAndView mav = new ModelAndView("suppliers-edit");
		Suppliers s = sservice.findOneSupplier(Integer.parseInt(supplierid));
		mav.addObject("suppliers", s);
		return mav;

	}

	@RequestMapping(value = "/edit/{supplierid}", method = RequestMethod.POST)
	public ModelAndView confirmEditSupplierPage(@ModelAttribute @Valid Suppliers supplier, BindingResult result,
			final RedirectAttributes redirattr, @PathVariable String supplierid) {
		
		if (result.hasErrors())
			return new ModelAndView("suppliers-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/suppliers/list");
		sservice.updateSupplier(supplier);
		String msg = "Supplier successfully updated.";
		redirattr.addFlashAttribute("message", msg);
		return mav;

	}

	@RequestMapping(value = "/delete/{supplierid}", method = RequestMethod.GET) // which record id
	public ModelAndView deleteSupplier(@PathVariable String supplierid, final RedirectAttributes redirattr) {
		ModelAndView mav = new ModelAndView("redirect:/admin/suppliers/list");
		Suppliers s = sservice.findOneSupplier(Integer.parseInt(supplierid));
		sservice.deleteSupplier(s);
		String msg = "Supplier successfully removed.";
		redirattr.addFlashAttribute("message", msg);
		return mav;
	}

}