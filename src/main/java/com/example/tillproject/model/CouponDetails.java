package com.example.tillproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CouponDetails")
public class CouponDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	String couponCode;
	
	String description;
	
	String discountType;
	
	float discountPercentage;
	
	int minQuantity;
	
	int freeQuantity;
		
	long applicableProductId;
	
	long offerProductId;
	
	@OneToOne
	Coupon coupon;
	
	public long getOfferProductId() {
		return offerProductId;
	}
	public void setOfferProductId(long offerProductId) {
		this.offerProductId = offerProductId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDiscountPercentage() {
		return discountPercentage;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public long getApplicableProductId() {
		return applicableProductId;
	}
	public void setApplicableProductId(long applicableProductId) {
		this.applicableProductId = applicableProductId;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public int getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
	public int getFreeQuantity() {
		return freeQuantity;
	}
	public void setFreeQuantity(int freeQuantity) {
		this.freeQuantity = freeQuantity;
	}
	
}
