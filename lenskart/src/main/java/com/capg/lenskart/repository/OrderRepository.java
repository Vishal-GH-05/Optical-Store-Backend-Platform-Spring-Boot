package com.capg.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
//	@Query(value = "select from Order where o.User.userId=?1 ")
//	public List<Order> orderList(int userId);
}
