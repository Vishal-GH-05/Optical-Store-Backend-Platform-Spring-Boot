package com.capg.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.Glass;
//import com.capg.lenskart.model.User;
@Repository
public interface GlassRepository extends JpaRepository<Glass, Integer>{
	 	@Query("FROM Glass ORDER BY price ASC")
	    List<Glass> sortProductByPrice();
	 	
	 	@Query("SELECT g FROM Glass g WHERE g.glassType=?1")
	    public List<Glass> viewProductByType(String type);
}
