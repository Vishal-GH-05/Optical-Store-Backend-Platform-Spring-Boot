package com.capg.lenskart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
//import com.capg.lenskart.model.Glass;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
//	@Query(value = "select g from Glass g where  g.glassId=?1 ")
//	public Glass addToCart(int glassId);
	@Modifying
	@Transactional
	@Query(value = "update Cart c set c.glassList=?1 where  c.cartId=?2 ")
	public int updateCart(List<Glass> glassList,int cartId);
	
	@Query(value = "select glassList from Cart c where c.cartId=?1 ")
	public List<Glass> glassList(int cartId);
	 
//	public Cart saveToCart(Glass glass);

}
