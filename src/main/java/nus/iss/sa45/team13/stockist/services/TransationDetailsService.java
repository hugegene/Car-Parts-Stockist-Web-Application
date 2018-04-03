package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import nus.iss.sa45.team13.stockist.model.TransationDetails;

public interface TransationDetailsService {
	
	ArrayList<TransationDetails> findAll();
	TransationDetails newTrandetails(TransationDetails t);
	
}
