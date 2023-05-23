package com.mazher.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.CategoryRepo;
import com.mazher.ecom.entity.Category;

@Service
public class Category_Service {
	
	@Autowired
	CategoryRepo categoryrepo;

	public List<Category> getCategory() {
		return categoryrepo.findAll();
	}

	public Category setCategory(Category category) {
		return categoryrepo.save(category);
	}
	
	

	
}
