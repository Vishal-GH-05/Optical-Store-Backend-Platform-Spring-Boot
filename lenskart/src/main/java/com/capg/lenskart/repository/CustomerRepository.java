package com.capg.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.User;
@Repository
public interface CustomerRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "select cart from User u where  u.userId=?1 ")
	public Cart getCartId(int userId);
	


}
