package com.example.tillproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tillproject.dto.TentativeCartDTO;
import com.example.tillproject.services.TentativeCartService;

@RestController
public class CartController {
	@Autowired
	TentativeCartService tentativeCartservice;
	
	@GetMapping("/getTentativeCartList")
	public Map<String,Object> getCartProducts(@RequestParam("empId") String empId)
	{
		return tentativeCartservice.getTentativeCartItems(empId);		
	}
	
	@PostMapping(path="/addTentativeCartList",produces="application/json")
	public void addTentativeCartProducts(@RequestBody TentativeCartDTO cartItem)
	{
		tentativeCartservice.addToTentativeCartList(cartItem);
	}

	@PostMapping("/addCouponToTentativeCartList")
	public void addToken(@RequestParam("empId") String empId,@RequestParam("couponCode") String couponCode) {
		tentativeCartservice.addCouponToTentativeCartItems(empId, couponCode);
	}
}