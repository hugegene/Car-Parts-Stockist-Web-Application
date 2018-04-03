package nus.iss.sa45.team13.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.sa45.team13.stockist.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT r FROM Role r")
	ArrayList<Role> getAllRoles();
	
	@Query("SELECT r from Role r WHERE r.staffId = :userId")
	Role findRoleByUserId(@Param("userId") Integer userId);
}