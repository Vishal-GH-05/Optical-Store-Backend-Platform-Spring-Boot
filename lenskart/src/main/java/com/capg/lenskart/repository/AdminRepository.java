package com.capg.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.lenskart.model.User;


public interface AdminRepository extends JpaRepository<User, Integer>{

//	@Query(value = "select u.userName from User u where u.userType= ?1")
//	public String viewAllCustomer(String userType);
	
	@Query(value = "select u from User u where u.userType= ?1")
	public List<User> findAllCustomer(String userType);
	
//	@Query(value = "delete g from Glass g where g.glassId= ?1")
//	public void deleteGlasses(int glassId);
	
}
