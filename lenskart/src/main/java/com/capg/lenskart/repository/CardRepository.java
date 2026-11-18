package com.capg.lenskart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.CardDetails;
import com.capg.lenskart.model.Order;

@Repository
public interface CardRepository extends JpaRepository<CardDetails, String>{
	
//	public String getCardDetails(String )

}
