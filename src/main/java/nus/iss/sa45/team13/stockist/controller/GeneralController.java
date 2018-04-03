package nus.iss.sa45.team13.stockist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {
	
	@RequestMapping(value= {"/about"})
	public ModelAndView AboutPage() {
		ModelAndView mav = new ModelAndView("about");
		
		return mav;
	}
	
	@RequestMapping(value= {"/access-denied"})
	public ModelAndView AccessDenied() {
		ModelAndView mav = new ModelAndView("accessdenied");
		
		return mav;
	}
}
