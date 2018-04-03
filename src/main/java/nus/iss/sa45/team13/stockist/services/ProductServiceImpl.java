package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.sa45.team13.stockist.model.Product;
import nus.iss.sa45.team13.stockist.model.Suppliers;
import nus.iss.sa45.team13.stockist.repository.ProductRepository;
import nus.iss.sa45.team13.stockist.repository.SuppliersRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductRepository prorepos;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findOne(int a) {
		// TODO Auto-generated method stub
		Product p = productRepository.findOne(a);
		return p;
	}

	@Override
	public ArrayList<Product> findAllProducts() {

		ArrayList<Product> al = (ArrayList<Product>) productRepository.findAll();
		return al;
	}

	@Override
	@Transactional
	public Product createProduct(Product p) {
		return prorepos.save(p);
	}

	@Override
	@Transactional
	public Product updateProduct(Product p) {
		return prorepos.save(p);
	}

	@Override
	@Transactional
	public void deleteProduct(Product p) {
		prorepos.delete(p);
	}

}
