package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import nus.iss.sa45.team13.stockist.model.Suppliers;

public interface SuppliersService {

	ArrayList<Suppliers> findAllSuppliers();

	Suppliers findOneSupplier(int supid);

	Suppliers createSupplier(Suppliers s);

	Suppliers updateSupplier(Suppliers s);

	void deleteSupplier(Suppliers s);

}