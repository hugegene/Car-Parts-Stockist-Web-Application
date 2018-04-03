package nus.iss.sa45.team13.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.sa45.team13.stockist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT e FROM Product e  where e.partName like CONCAT('%',:partname,'%')")
	ArrayList<Product> findProductByName(@Param("partname") String partname);
	
	@Query("SELECT e FROM Product e  where e.partNumber like CONCAT('%',:partNumber,'%')")
	ArrayList<Product> findProductByNumber(@Param("partNumber") int partNumber);
	
}
