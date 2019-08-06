package com.example.tillproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tillproject.dto.ProductDTO;
import com.example.tillproject.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path="/productList",produces = "application/json")
	public List<ProductDTO> getproducts()
	{	    	
		return productService.getProductList();
	}
}
