package com.mazher.ecom.controller;


import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.dao.RoleRepo;
import com.mazher.ecom.entity.Customer;
import com.mazher.ecom.service.Customer_Service;

@RestController
@RequestMapping("api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class Customer_Controller {
	
	@Autowired
	Customer_Service customerservice;
	
	@Autowired
	CustomerRepo customerrepo;
	
	@Autowired
	RoleRepo rolerepo;
	
	@PostMapping("/register")
	public Customer getRegisterUser(@RequestBody Customer userlog) {
		return customerservice.getRegisterUser(userlog);

	}

	
	@PutMapping("/updatepassword/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void updatePassword(@PathVariable("id") Long id, @RequestBody Customer customer) {
		customerservice.updatePassword(id,customer);
		
	}
	
	@GetMapping("/get")
	@RolesAllowed("ROLE_ADMIN")
	public String get() {
		String x = "hello";
		return x;
	}
	
}
