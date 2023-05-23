package com.mazher.ecom.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mazher.ecom.entity.Purchased;

@Repository
public interface PurchasedRepo extends JpaRepository<Purchased, Long>{
	
	@Query("select u from Purchased u where u.customer.id=:n")
	List<Purchased> findPurchasedItemByCustomerId(@Param("n") Long id);

}
