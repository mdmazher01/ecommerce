package com.mazher.ecom.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazher.ecom.entity.Purchased;
import com.mazher.ecom.service.Purchased_Service;

@RestController
@RequestMapping("api/purchased")
@CrossOrigin(origins = "http://localhost:4200")
public class Purchased_Controller {
	
	@Autowired
	Purchased_Service purchasedservice;
	
	
	@PostMapping("/register/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public Purchased getRegister(@PathVariable("id") Long id, @RequestBody Purchased purchasedLogs) {
		return purchasedservice.getRegister(id,purchasedLogs);
		
		
	}
	
	@GetMapping("/getpurchaseditem")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Purchased> getAllPurchased(){
		return purchasedservice.getAllPurchased();
	}
	
	@GetMapping("/getpurchaseditem/customerid/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Purchased> getPurchasedItemByCustomer(@PathVariable("id") Long id){
		return purchasedservice.getPurchasedItemByCustomer(id);
	}
	
	@DeleteMapping("/deletepurchased/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void getDeletePurchased(@PathVariable("id") Long id) {
		purchasedservice.getDeletePurchased(id);
	}
}
