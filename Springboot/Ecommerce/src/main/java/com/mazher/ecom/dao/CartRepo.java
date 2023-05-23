package com.mazher.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazher.ecom.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{
	
	@Query("select u from Cart u where u.customer.id=:n")
	List<Cart> findCartItemByCustomerId(@Param("n") Long id);
	
	@Query("select count(u) from Cart u where u.customer.id=:n")
	int getCount(@Param("n") Long id);
	
	@Query("select u from Cart u where u.id=:j")
	List<Cart> findCartById(@Param("j") Long id);

}
