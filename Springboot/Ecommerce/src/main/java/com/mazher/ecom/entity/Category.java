package com.mazher.ecom.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="category_name")
	private String category_name;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product> product;

	public Category() {
		super();
	}

	public Category(Long id, String category_name, List<Product> product) {
		super();
		this.id = id;
		this.category_name = category_name;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category_name=" + category_name + ", product=" + product + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@JsonManagedReference
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	

}
