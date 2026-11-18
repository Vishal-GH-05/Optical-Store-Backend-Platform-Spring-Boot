package com.capg.lenskart.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.lenskart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query(value = "select u from User u where u.userName=?1 and u.userPassword=?2 ")
	public User getLogin(String userName, String userPassword);


	@Query(value="select u.userPassword from User u where u.userName=?1 and u.secretAnswer=?2 ")
	public String forgotPassword(String userName, String secretAnswer);
		
	@Query(value="select u.userId from User u where u.userName=?1 and u.secretAnswer=?2")
	public int getUserId(String userName, String secretAnswer);
//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query(value = "INSERT INTO product_table values(?1,?2,?3,?4)",nativeQuery = true)
//	public int regUser(int productId,String productName,double productPrice,String productType);

}
