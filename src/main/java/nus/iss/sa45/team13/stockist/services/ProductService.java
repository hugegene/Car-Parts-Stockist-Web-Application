package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import nus.iss.sa45.team13.stockist.model.Product;

public interface ProductService {

	Product findOne(int a);

	ArrayList<Product> findAllProducts();

	Product createProduct(Product p);
	
	Product updateProduct(Product p);
	
	void deleteProduct(Product p);

}
