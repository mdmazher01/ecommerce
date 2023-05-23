package com.mazher.ecom.controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mazher.ecom.entity.Cart;
import com.mazher.ecom.service.Cart_Service;

@RestController
@RequestMapping("api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class Cart_Controller {
	
	@Autowired
	Cart_Service cartservice;
	
	@PostMapping("/registerCartItem/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public Cart getRegisterCartItem(@PathVariable("id") Long id, @RequestBody Cart cartlogs) {
		return cartservice.getRegisterCartItem(id,cartlogs);
	}
	
	@GetMapping("/getCartItem")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Cart> getItem(){
		return cartservice.getCartItem();
	}
	
	@GetMapping("/getCartItem/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Cart> getItemById(@PathVariable("id") Long id){
		return cartservice.getCartItemById(id);
	}
	
	@GetMapping("/getCartItem/customerid/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Cart> getCartItemByCustomerId(@PathVariable("id") Long id){
		return cartservice.getCartItemByCustomerId(id);
	}
	
	@PutMapping("/updateQuantityAndPrice/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void updateQuantityAndPrice(@PathVariable("id") Long id,@RequestBody Cart cartlogs) {
		cartservice.updateQuantityAndPrice(id,cartlogs);
		
	}
	
	@PutMapping("/decQuantityAndPrice/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void decQuantityAndPrice(@PathVariable("id") Long id,@RequestBody Cart cartlogs) {
		cartservice.decQuantityAndPrice(id,cartlogs);
	}
	
	
	@DeleteMapping("/deleteCartItem/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void deleteCartItemById(@PathVariable("id") Long id) {
		cartservice.deleteCartItemById(id);
	}
	
	@GetMapping("/cartCount/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public int getCartCount(@PathVariable("id") Long id) {
		return cartservice.getCartCount(id);
	}
	
}
