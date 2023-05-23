package com.mazher.ecom.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="product_description")
	private String product_description;
	
	@Column(name="product_unit_price")
	private BigDecimal product_unit_price;
	
	@Column(name="product_unit_instock")
	private int product_unit_instock;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="product_datecreated")
	@CreationTimestamp
	private Date product_datecreated;
	
	@Column(name="product_lastupdated")
	@UpdateTimestamp
	private Date product_lastupdated;
	
	@Column(name="product_discount_price")
	private BigDecimal product_discount_price;
	
	@Column(name="product_sale_count")
	private int product_sale_count;
	
	@Column(name="product_discount_percentage")
	private String product_discount_percentage;
	
	@OneToMany( mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Product_Images> productImages;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	

	public Product() {
		super();
	}

	
	
	
	
	
	public Product(Long id, String product_name, String product_description, BigDecimal product_unit_price,
			int product_unit_instock, boolean active, Date product_datecreated, Date product_lastupdated,
			BigDecimal product_discount_price, int product_sale_count, String product_discount_percentage,
			Set<Product_Images> productImages, Category category) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_unit_price = product_unit_price;
		this.product_unit_instock = product_unit_instock;
		this.active = active;
		this.product_datecreated = product_datecreated;
		this.product_lastupdated = product_lastupdated;
		this.product_discount_price = product_discount_price;
		this.product_sale_count = product_sale_count;
		this.product_discount_percentage = product_discount_percentage;
		this.productImages = productImages;
		this.category = category;
	}






	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_description=" + product_description
				+ ", product_unit_price=" + product_unit_price + ", product_unit_instock=" + product_unit_instock
				+ ", active=" + active + ", product_datecreated=" + product_datecreated + ", product_lastupdated="
				+ product_lastupdated + ", product_discount_price=" + product_discount_price + ", product_sale_count="
				+ product_sale_count + ", product_discount_percentage=" + product_discount_percentage
				+ ", productImages=" + productImages + ", category=" + category + "]";
	}






	public String getProduct_discount_percentage() {
		return product_discount_percentage;
	}


	public void setProduct_discount_percentage(String product_discount_percentage) {
		this.product_discount_percentage = product_discount_percentage;
	}


	

	




	

	public int getProduct_sale_count() {
		return product_sale_count;
	}



	public void setProduct_sale_count(int product_sale_count) {
		this.product_sale_count = product_sale_count;
	}



	public BigDecimal getProduct_discount_price() {
		return product_discount_price;
	}

	public void setProduct_discount_price(BigDecimal product_discount_price) {
		this.product_discount_price = product_discount_price;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public BigDecimal getProduct_unit_price() {
		return product_unit_price;
	}

	public void setProduct_unit_price(BigDecimal product_unit_price) {
		this.product_unit_price = product_unit_price;
	}

	public int getProduct_unit_instock() {
		return product_unit_instock;
	}

	public void setProduct_unit_instock(int product_unit_instock) {
		this.product_unit_instock = product_unit_instock;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getProduct_datecreated() {
		return product_datecreated;
	}

	public void setProduct_datecreated(Date product_datecreated) {
		this.product_datecreated = product_datecreated;
	}

	public Date getProduct_lastupdated() {
		return product_lastupdated;
	}

	public void setProduct_lastupdated(Date product_lastupdated) {
		this.product_lastupdated = product_lastupdated;
	}
	
	@JsonManagedReference
	public Set<Product_Images> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<Product_Images> productImages) {
		this.productImages = productImages;
	}


	@JsonBackReference
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
}
