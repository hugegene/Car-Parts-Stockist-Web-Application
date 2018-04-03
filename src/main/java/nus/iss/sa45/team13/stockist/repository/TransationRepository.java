package nus.iss.sa45.team13.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.sa45.team13.stockist.model.Transation;

public interface TransationRepository extends JpaRepository<Transation, Integer> {

	/*@Modifying
	@Query("insert into transaction tt (tt.staffid, tt.datetime, tt.licenseplateno, tt.remarks) values (:staffid,:datetime,:licenseplateno,:remarks)")
	public void addData(@Param("staffid") Integer staffid,@Param("datetime") String datetime,@Param("licenseplateno") String licenseplateno, @Param("remarks") String remarks);
	*/
	
	
	
	
}
