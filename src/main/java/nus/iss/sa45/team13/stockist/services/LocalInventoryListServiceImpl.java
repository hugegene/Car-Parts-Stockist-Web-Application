package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;

import nus.iss.sa45.team13.stockist.repository.LocalInventoryListRepository;

@Service
public class LocalInventoryListServiceImpl implements LocalInventoryListService {

	@Autowired
	private LocalInventoryListRepository localRepository;

	@Override
	public LocalinventoryList findOne(int partno) {

		return localRepository.findOne(partno);
	}

	@Override
	public ArrayList<LocalinventoryList> findAll() {

		return (ArrayList<LocalinventoryList>) localRepository.findAll();
	}

	@Override
	public LocalinventoryList reduceQty(LocalinventoryList local) {
		
		return localRepository.save(local);
	}



}
