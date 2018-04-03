package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import nus.iss.sa45.team13.stockist.model.Transation;
import nus.iss.sa45.team13.stockist.repository.TransationRepository;

@Service
public class TransationServiceImpl implements TransationService {

	@Autowired
	private TransationRepository transationRepository;
	
	
	

	@Override
	public Transation findTransation(int tranid) {
		
		return transationRepository.findOne(tranid);
	}

	@Override
	public ArrayList<Transation> findAll() {
		ArrayList<Transation> s=(ArrayList<Transation>) transationRepository.findAll();
		return s;
	}

	@Override
	public Transation newTranRrecordPage(Transation t) {
		return transationRepository.save(t);
	}
	
	

	


}
