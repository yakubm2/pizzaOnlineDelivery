package com.example.tillproject.dto;


public class ProductDTO {
	long id;
	String name;
	String producttype;
	String size;
	float price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getproducttype() {
		return producttype;
	}
	public void setproducttype(String producttype) {
		this.producttype = producttype;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
