package com.capg.lenskart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
