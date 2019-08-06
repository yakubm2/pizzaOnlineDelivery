package com.example.tillproject.dto;

public class TentativeCartDTO {
	String empId;
	String employeeName;
	
	String companyId;
	String companyName;
	
	String productId;
	String productName;
	
	String price;
	
	int quantity;
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmployeeId() {
		return empId;
	}

	public void setEmployeeId(String empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


    long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
