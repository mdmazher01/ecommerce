package com.mazher.ecom.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="purchased")
public class Purchased {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="purchased_product_id")
	private	Long purchased_product_id;
	
	@Column(name="purchased_product_image")
	private String purchased_product_image;
	
	@Column(name="purchased_product_trackingid")
	private String purchased_product_trackingid;
	
	@Column(name="purchased_product_name")
	private String purchased_product_name;
	
	@Column(name="purchased_product_price")
	private BigDecimal purchased_product_price;
	
	@Column(name="purchased_product_quantity")
	private BigDecimal purchased_product_quantity;
	
	@Column(name="purchased_product_date")
	@CreationTimestamp
	private Date purchased_product_date;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "track_id", referencedColumnName = "id")
	private Track track;

	public Purchased() {
		super();
	}

	public Purchased(Long id, Long purchased_product_id, String purchased_product_image,
			String purchased_product_trackingid, String purchased_product_name, BigDecimal purchased_product_price,
			BigDecimal purchased_product_quantity, Date purchased_product_date, Customer customer, Track track) {
		super();
		this.id = id;
		this.purchased_product_id = purchased_product_id;
		this.purchased_product_image = purchased_product_image;
		this.purchased_product_trackingid = purchased_product_trackingid;
		this.purchased_product_name = purchased_product_name;
		this.purchased_product_price = purchased_product_price;
		this.purchased_product_quantity = purchased_product_quantity;
		this.purchased_product_date = purchased_product_date;
		this.customer = customer;
		this.track = track;
	}

	@Override
	public String toString() {
		return "Purchased [id=" + id + ", purchased_product_id=" + purchased_product_id + ", purchased_product_image="
				+ purchased_product_image + ", purchased_product_trackingid=" + purchased_product_trackingid
				+ ", purchased_product_name=" + purchased_product_name + ", purchased_product_price="
				+ purchased_product_price + ", purchased_product_quantity=" + purchased_product_quantity
				+ ", purchased_product_date=" + purchased_product_date + ", customer=" + customer + ", track=" + track
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchased_product_id() {
		return purchased_product_id;
	}

	public void setPurchased_product_id(Long purchased_product_id) {
		this.purchased_product_id = purchased_product_id;
	}

	public String getPurchased_product_image() {
		return purchased_product_image;
	}

	public void setPurchased_product_image(String purchased_product_image) {
		this.purchased_product_image = purchased_product_image;
	}

	public String getPurchased_product_trackingid() {
		return purchased_product_trackingid;
	}

	public void setPurchased_product_trackingid(String purchased_product_trackingid) {
		this.purchased_product_trackingid = purchased_product_trackingid;
	}

	public String getPurchased_product_name() {
		return purchased_product_name;
	}

	public void setPurchased_product_name(String purchased_product_name) {
		this.purchased_product_name = purchased_product_name;
	}

	public BigDecimal getPurchased_product_price() {
		return purchased_product_price;
	}

	public void setPurchased_product_price(BigDecimal purchased_product_price) {
		this.purchased_product_price = purchased_product_price;
	}

	public BigDecimal getPurchased_product_quantity() {
		return purchased_product_quantity;
	}

	public void setPurchased_product_quantity(BigDecimal purchased_product_quantity) {
		this.purchased_product_quantity = purchased_product_quantity;
	}

	public Date getPurchased_product_date() {
		return purchased_product_date;
	}

	public void setPurchased_product_date(Date purchased_product_date) {
		this.purchased_product_date = purchased_product_date;
	}
	
	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	

	

	
	
	
	

}
