package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;


public interface LocalInventoryListService {
	
	LocalinventoryList findOne(int partno);
	ArrayList<LocalinventoryList> findAll();
	LocalinventoryList reduceQty(LocalinventoryList local);
	
}
