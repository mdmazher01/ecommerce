package com.mazher.ecom.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.CategoryRepo;
import com.mazher.ecom.dao.ProductRepo;
import com.mazher.ecom.entity.Category;
import com.mazher.ecom.entity.Product;


@Service
public class Product_Service {
	
	@Autowired
	ProductRepo productrepo;
	
	@Autowired
	CategoryRepo categoryrepo;
	
	public List<Product> getProduct(){
		return productrepo.findAll();
	}

	public Product registerProduct(Long id,Product pro) {
		Category cat = categoryrepo.findById(id).get();
		pro.setCategory(cat);
		return productrepo.save(pro);
	}

	public List<Product> getProductById(Long id) {
		return  productrepo.findProductById(id);
		
		
	}

	public List<Product> getProductByCategoryId(Long id) {
		return  productrepo.findProductByCategoryId(id);
	}

	public Long getProductIdByName(String name) {
		return  productrepo.findProductIdByName(name);
	}

	public void updateProduct(Long id, Product prod) {

		if(prod.getProduct_discount_price() != null) {
			DecimalFormat dec = new DecimalFormat("#0.00");
			BigDecimal val1 = new BigDecimal("100");
			BigDecimal x = prod.getProduct_unit_price().subtract(prod.getProduct_discount_price());
			BigDecimal y = x.divide(prod.getProduct_unit_price(), 3, RoundingMode.FLOOR);
			BigDecimal z = y.multiply(val1);
			String str=z.toString(); 
			Product data = productrepo.findById(id).get();
			data.setProduct_name(prod.getProduct_name());
			data.setProduct_description(prod.getProduct_description());
			data.setProduct_unit_price(prod.getProduct_unit_price());
			data.setProduct_unit_instock(prod.getProduct_unit_instock());
			data.setProduct_discount_price(prod.getProduct_discount_price());
			data.setProduct_discount_percentage(str);
			data.setActive(prod.isActive());
			productrepo.save(data);
		}
		else {
			
			Product data = productrepo.findById(id).get();
			data.setProduct_name(prod.getProduct_name());
			data.setProduct_description(prod.getProduct_description());
			data.setProduct_unit_price(prod.getProduct_unit_price());
			data.setProduct_unit_instock(prod.getProduct_unit_instock());
			data.setProduct_discount_price(prod.getProduct_discount_price());
			data.setProduct_discount_percentage(null);
			data.setActive(prod.isActive());
			productrepo.save(data);
			
		}
		
	}

	public void deleteProduct(Long id) {
		productrepo.deleteById(id);
	}

	public void updateSaleAndStock(Long id) {
		Product data = productrepo.findById(id).get();
		data.setProduct_sale_count(data.getProduct_sale_count() + 1);
		data.setProduct_unit_instock(data.getProduct_unit_instock() - 1);
		productrepo.save(data);
		
	}

	public void updateSaleAndStockOnCancelRequest(Long id) {
		Product data = productrepo.findById(id).get();
		data.setProduct_sale_count(data.getProduct_sale_count() - 1);
		data.setProduct_unit_instock(data.getProduct_unit_instock() + 1);
		productrepo.save(data);
		
		
	}

	

	

}
