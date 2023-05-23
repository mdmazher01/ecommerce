package com.mazher.ecom.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="cart_item_product_id")
	private Long cart_item_product_id;
	
	@Column(name="cart_item_image")
	private String cart_item_image;
	
	@Column(name="cart_item_name")
	private String cart_item_name;
	
	@Column(name="cart_item_size")
	private BigDecimal cart_item_size;
	
	@Column(name="cart_item_price")
	private BigDecimal cart_item_price;
	
	@Column(name="cart_item_quantity")
	private BigDecimal cart_item_quantity;
	
	@Column(name="cart_item_totalprice")
	private BigDecimal cart_item_totalprice;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Cart() {
		super();
	}

	public Cart(Long id, Long cart_item_product_id, String cart_item_image, String cart_item_name,
			BigDecimal cart_item_size, BigDecimal cart_item_price, BigDecimal cart_item_quantity,
			BigDecimal cart_item_totalprice, Customer customer) {
		super();
		this.id = id;
		this.cart_item_product_id = cart_item_product_id;
		this.cart_item_image = cart_item_image;
		this.cart_item_name = cart_item_name;
		this.cart_item_size = cart_item_size;
		this.cart_item_price = cart_item_price;
		this.cart_item_quantity = cart_item_quantity;
		this.cart_item_totalprice = cart_item_totalprice;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cart_item_product_id=" + cart_item_product_id + ", cart_item_image="
				+ cart_item_image + ", cart_item_name=" + cart_item_name + ", cart_item_size=" + cart_item_size
				+ ", cart_item_price=" + cart_item_price + ", cart_item_quantity=" + cart_item_quantity
				+ ", cart_item_totalprice=" + cart_item_totalprice + ", customer=" + customer + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCart_item_product_id() {
		return cart_item_product_id;
	}

	public void setCart_item_product_id(Long cart_item_product_id) {
		this.cart_item_product_id = cart_item_product_id;
	}

	public String getCart_item_image() {
		return cart_item_image;
	}

	public void setCart_item_image(String cart_item_image) {
		this.cart_item_image = cart_item_image;
	}

	public String getCart_item_name() {
		return cart_item_name;
	}

	public void setCart_item_name(String cart_item_name) {
		this.cart_item_name = cart_item_name;
	}

	public BigDecimal getCart_item_size() {
		return cart_item_size;
	}

	public void setCart_item_size(BigDecimal cart_item_size) {
		this.cart_item_size = cart_item_size;
	}

	public BigDecimal getCart_item_price() {
		return cart_item_price;
	}

	public void setCart_item_price(BigDecimal cart_item_price) {
		this.cart_item_price = cart_item_price;
	}

	public BigDecimal getCart_item_quantity() {
		return cart_item_quantity;
	}

	public void setCart_item_quantity(BigDecimal cart_item_quantity) {
		this.cart_item_quantity = cart_item_quantity;
	}

	public BigDecimal getCart_item_totalprice() {
		return cart_item_totalprice;
	}

	public void setCart_item_totalprice(BigDecimal cart_item_totalprice) {
		this.cart_item_totalprice = cart_item_totalprice;
	}
	
	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
	
	
	
	
	
}
