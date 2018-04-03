package nus.iss.sa45.team13.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import nus.iss.sa45.team13.stockist.model.Suppliers;

public interface SuppliersRepository extends JpaRepository<Suppliers, Integer>{
	
}
