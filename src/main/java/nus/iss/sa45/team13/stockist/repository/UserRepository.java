package nus.iss.sa45.team13.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.sa45.team13.stockist.model.User;


public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT r from User r WHERE r.staffId = :userId")
	User findUserByUserId(@Param("userId") String userId);
}
