package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import nus.iss.sa45.team13.stockist.model.Transation;

public interface TransationService {

	ArrayList<Transation> findAll();
	Transation findTransation(int tranid);
	Transation newTranRrecordPage(Transation tt);
}
