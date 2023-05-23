package com.mazher.ecom.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mazher.ecom.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	@Query("select u.id from Customer u where u.email=:a and u.password=:b")
	Long findCustomerIdByEmailAndPassword(@Param("a") String email,@Param("b") String password);

	Optional<Customer> findByEmail(String email);
	
	@Query("select u from Customer u where u.email=:c")
	Customer findCustomerByEmail(@Param("c") String email);

	

	

}
