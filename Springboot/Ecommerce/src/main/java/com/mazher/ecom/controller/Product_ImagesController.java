package com.mazher.ecom.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mazher.ecom.entity.Product_Images;
import com.mazher.ecom.service.Product_ImagesService;

@RestController
@RequestMapping("api/image")
@CrossOrigin(origins = "http://localhost:4200")
public class Product_ImagesController {
	
	@Autowired
	Product_ImagesService product_imagesservice;
	
	@GetMapping("/all")
	public List<Product_Images> getProduct() {
		return product_imagesservice.getProduct();
	}
	
	
	@PostMapping("/setproductimages/{id}")
	public Product_Images uploadImages(@PathVariable("id") Long id,@RequestBody Product_Images productImg) {
		return product_imagesservice.uploadImages(id,productImg);
	}
	
	@GetMapping("/getimagebyid/{id}")
	public List<Product_Images> getImageById(@PathVariable("id") Long id){
		return product_imagesservice.getImageById(id);
	}
	
	@PutMapping("/updateimage/{id}")
	public void getImageUpdate(@PathVariable("id") Long id, @RequestBody Product_Images productImg) {
		product_imagesservice.getImageUpdate(id,productImg);
	}

}
