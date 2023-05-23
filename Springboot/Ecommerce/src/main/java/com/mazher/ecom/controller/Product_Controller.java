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

import com.mazher.ecom.entity.Category;
import com.mazher.ecom.entity.Product;
import com.mazher.ecom.service.Product_Service;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class Product_Controller {
	
	@Autowired
	Product_Service service;
	
	@GetMapping("/all")
	public List<Product> getProduct() {
		return service.getProduct();
	}
	
	
	@GetMapping("search/findbyproductid/{id}")
	public List<Product> getProductById(@PathVariable("id") Long id){
		return service.getProductById(id);
	}
	
	@GetMapping("search/findproductid/name/{name}")
	public Long getProductIdByName(@PathVariable("name") String name) {
		return service.getProductIdByName(name);
	}
	
	@PostMapping("/registerproduct/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public Product registerProduct(@PathVariable("id") Long id,@RequestBody Product pro) {
		return service.registerProduct(id,pro);
	}
	
	@GetMapping("search/findbycategoryid/{id}")
	public List<Product> getProductByCategoryId(@PathVariable("id") Long id){
		return service.getProductByCategoryId(id);
	}
	
	@PutMapping("/updateproduct/{id}")
	public void updateProduct(@PathVariable("id") Long id, @RequestBody Product prod) {
		service.updateProduct(id,prod);
	}
	
	@PutMapping("/updateproduct/saleandstock/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void updateSaleAndStock(@PathVariable("id") Long id) {
		service.updateSaleAndStock(id);
		
		
	}
	
	@PutMapping("/updateproductoncancel/oncancelrequest/{id}")
	@RolesAllowed("ROLE_CUSTOMER")
	public void updateSaleAndStockOnCancelRequest(@PathVariable("id") Long id){
		service.updateSaleAndStockOnCancelRequest(id);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		service.deleteProduct(id);
	}
	
	
	
}
