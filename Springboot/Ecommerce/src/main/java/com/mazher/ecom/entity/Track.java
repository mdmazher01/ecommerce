package com.mazher.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="image")
	private String image;
	
	@Column(name="trackingid")
	private String trackingid;
	
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="orderconfirmed")
	private boolean orderconfirmed;
	
	@Column(name="pickedbycourier")
	private boolean pickedbycourier;
	
	@Column(name="ontheway")
	private boolean ontheway;
	
	@Column(name="outfordelivery")
	private boolean outfordelivery;
	
	@Column(name="pending")
	private boolean pending;
	
	@Column(name="delivered")
	private boolean delivered;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private Purchased purchased;

	public Track() {
		super();
		
	}

	public Track(Long id, String image, String trackingid, String productname, boolean orderconfirmed,
			boolean pickedbycourier, boolean ontheway, boolean outfordelivery, boolean pending, boolean delivered,
			Purchased purchased) {
		super();
		this.id = id;
		this.image = image;
		this.trackingid = trackingid;
		this.productname = productname;
		this.orderconfirmed = orderconfirmed;
		this.pickedbycourier = pickedbycourier;
		this.ontheway = ontheway;
		this.outfordelivery = outfordelivery;
		this.pending = pending;
		this.delivered = delivered;
		this.purchased = purchased;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", image=" + image + ", trackingid=" + trackingid + ", productname=" + productname
				+ ", orderconfirmed=" + orderconfirmed + ", pickedbycourier=" + pickedbycourier + ", ontheway="
				+ ontheway + ", outfordelivery=" + outfordelivery + ", pending=" + pending + ", delivered=" + delivered
				+ ", purchased=" + purchased + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTrackingid() {
		return trackingid;
	}

	public void setTrackingid(String trackingid) {
		this.trackingid = trackingid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public boolean isOrderconfirmed() {
		return orderconfirmed;
	}

	public void setOrderconfirmed(boolean orderconfirmed) {
		this.orderconfirmed = orderconfirmed;
	}

	public boolean isPickedbycourier() {
		return pickedbycourier;
	}

	public void setPickedbycourier(boolean pickedbycourier) {
		this.pickedbycourier = pickedbycourier;
	}

	public boolean isOntheway() {
		return ontheway;
	}

	public void setOntheway(boolean ontheway) {
		this.ontheway = ontheway;
	}

	public boolean isOutfordelivery() {
		return outfordelivery;
	}

	public void setOutfordelivery(boolean outfordelivery) {
		this.outfordelivery = outfordelivery;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public Purchased getPurchased() {
		return purchased;
	}

	public void setPurchased(Purchased purchased) {
		this.purchased = purchased;
	}

	
	

	
	
	
}
