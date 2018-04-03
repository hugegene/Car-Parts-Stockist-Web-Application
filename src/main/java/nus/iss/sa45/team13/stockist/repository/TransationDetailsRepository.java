package nus.iss.sa45.team13.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nus.iss.sa45.team13.stockist.model.TransationDetails;
import nus.iss.sa45.team13.stockist.model.TransationDetailsPK;

public interface TransationDetailsRepository extends JpaRepository<TransationDetails, TransationDetailsPK> {

	
}
