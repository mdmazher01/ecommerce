package com.mazher.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.ProductRepo;
import com.mazher.ecom.dao.Product_ImagesRepo;
import com.mazher.ecom.entity.Product;
import com.mazher.ecom.entity.Product_Images;

@Service
public class Product_ImagesService {
	
	@Autowired
	Product_ImagesRepo product_imagesrepo;
	
	@Autowired
	ProductRepo productrepo;
	
	public List<Product_Images> getProduct(){
		return product_imagesrepo.findAll();
	}
	
	public Product_Images uploadImages(Long id,Product_Images productImg) {
		Product prod = productrepo.findById(id).get();
		productImg.setProduct(prod);
		return product_imagesrepo.save(productImg);
	}

	public List<Product_Images> getImageById(Long id) {
		return product_imagesrepo.findImageId(id);
	}

	public void getImageUpdate(Long id, Product_Images productImg) {
		Product_Images data = product_imagesrepo.findById(id).get();
		data.setImage1(productImg.getImage1());
		data.setImage2(productImg.getImage2());
		data.setImage3(productImg.getImage3());
		data.setImage4(productImg.getImage4());
		data.setImage5(productImg.getImage5());
		product_imagesrepo.save(data);
	}
}
