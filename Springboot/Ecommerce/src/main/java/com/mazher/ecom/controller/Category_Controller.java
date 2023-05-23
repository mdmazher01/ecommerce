package com.mazher.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazher.ecom.entity.Category;
import com.mazher.ecom.service.Category_Service;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "http://localhost:4200")
public class Category_Controller {
	
	@Autowired
	Category_Service categoryservice;
	
	
	@GetMapping("/all")
	public List<Category> getCategory(){
		return categoryservice.getCategory();
	}
	
	@PostMapping("/setcategory")
	public Category setCategory(@RequestBody Category category) {
		return categoryservice.setCategory(category);
	}
}
