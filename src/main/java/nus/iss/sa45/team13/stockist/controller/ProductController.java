package nus.iss.sa45.team13.stockist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;
import nus.iss.sa45.team13.stockist.model.Product;
import nus.iss.sa45.team13.stockist.services.LocalInventoryListService;
import nus.iss.sa45.team13.stockist.services.ProductService;
import nus.iss.sa45.team13.stockist.validators.ProductValidator;


@Controller
public class ProductController {

	@Autowired
	private ProductService pService;

	@Autowired
	private ProductValidator pValidator;

	@Autowired
	private LocalInventoryListService iService;


	@InitBinder("product")
	private void initProductBinder(WebDataBinder binder) {
		binder.setValidator(pValidator);
	}

	Map<Integer, Integer> saved = new HashMap<Integer, Integer>();

	@RequestMapping(value = "/viewproduct/{partNumber}", method = RequestMethod.GET)
	public ModelAndView ProductDetails(@PathVariable int partNumber) {

		Product product = pService.findOne(partNumber);
		Product emptyproduct = new Product();
		ModelAndView mav = new ModelAndView("viewproduct", "currentproduct", product);
		mav.addObject("emptyproduct", emptyproduct);
		return mav;

	}

	@RequestMapping(value = "/admin/viewproduct/list", method = RequestMethod.GET)
	public ModelAndView ProductListPage() {
		ModelAndView mav = new ModelAndView("product-list");
		ArrayList<Product> productList = (ArrayList<Product>) pService.findAllProducts();
		mav.addObject("productList", productList);

		return mav;

	}

	@RequestMapping(value = "/admin/viewproduct/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView("product-new", "product", p);
		return mav;

	}

	@RequestMapping(value = "/admin/viewproduct/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirattr) {

		if (result.hasErrors())
			return new ModelAndView("product-new");

		ModelAndView mav = new ModelAndView();
		pService.createProduct(product);

		String message = "New Product " + product.getPartNumber() + ", " + product.getPartName() + " has been created.";
		mav.setViewName("redirect:/admin/viewproduct/list");
		redirattr.addFlashAttribute("message", message);
		return mav;

	}

	@RequestMapping(value = "/admin/viewproduct/edit/{partNumber}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable String partNumber) {
		ModelAndView mav = new ModelAndView("product-edit");
		Product p = pService.findOne(Integer.parseInt(partNumber));
		mav.addObject("product", p);
		return mav;

	}

	@RequestMapping(value = "/admin/viewproduct/edit/{partNumber}", method = RequestMethod.POST)
	public ModelAndView confirmEditProductPage(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirattr, @PathVariable String partNumber) {
		if (result.hasErrors())
			return new ModelAndView("product-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/viewproduct/list");
		pService.updateProduct(product);
		String msg = "Product successfully updated.";
		redirattr.addFlashAttribute("message", msg);
		return mav;
	}

	@RequestMapping(value = "/admin/viewproduct/delete/{partNumber}", method = RequestMethod.GET) // which record id
	public ModelAndView deleteProduct(@PathVariable String partNumber, final RedirectAttributes redirattr) {
		ModelAndView mav = new ModelAndView("redirect:/admin/viewproduct/list");
		Product p = pService.findOne(Integer.parseInt(partNumber));
		pService.deleteProduct(p);
		String msg = "Product successfully removed.";
		redirattr.addFlashAttribute("message", msg);
		return mav;
	}

	@RequestMapping(value = "/viewproduct/{partNumber}", method = RequestMethod.POST)
	public ModelAndView AddToCart(@ModelAttribute("emptyproduct") @Valid Product savedQty, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession httpSession, @PathVariable int partNumber) {

		if (result.hasErrors())
			return new ModelAndView("redirect:/catalog");
		
		int qtyLeft = ((LocalinventoryList)(iService.findOne(partNumber))).getStoreqty();
		if(savedQty.getPartNumber()> qtyLeft) {
			ModelAndView mav = new ModelAndView("redirect:/catalog");
			redirectAttributes.addAttribute("catalogError", new Integer(1));
			return mav;
		}
		
		Product savedproduct = pService.findOne(partNumber);
		System.out.println("savedproduct found" + savedproduct.toString());

		saved.put(partNumber, savedQty.getPartNumber());

		httpSession.setAttribute("saved", saved);

		Set set = saved.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("partnumber is " + mentry.getKey() + "qty is ");
			System.out.println(mentry.getValue());
		}

		System.out.println(
				"Productsesson found" + ((Map<Integer, Integer>) httpSession.getAttribute("saved")).get(partNumber));
		ModelAndView mav = new ModelAndView("redirect:/catalog");
		return mav;
	}

}
