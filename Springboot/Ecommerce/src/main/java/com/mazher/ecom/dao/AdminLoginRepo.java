package com.mazher.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazher.ecom.entity.AdminLogin;


@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLogin, Long>{
	
	@Query("select u from AdminLogin u where u.email =:n and u.password =:j")
	List<AdminLogin> getAdminByEmailAndPassword(@Param("n") String admin, @Param("j") String password);
	
	
	
	@Query("select u from AdminLogin u where u.email =:k")
	AdminLogin findAdminByEmail(@Param("k") String email);
}
