package nus.iss.sa45.team13.stockist.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import nus.iss.sa45.team13.stockist.model.LocalinventoryList;

import nus.iss.sa45.team13.stockist.services.LocalInventoryListService;

@Controller
public class LocalInventoryListController {
	
	@Autowired
	LocalInventoryListService localService;
	LocalinventoryList l = new LocalinventoryList();
	int newqty = l.getStoreqty()-1;

}
