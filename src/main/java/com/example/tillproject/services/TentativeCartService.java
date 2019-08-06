package com.example.tillproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tillproject.dto.TentativeCartDTO;
import com.example.tillproject.model.TentativeCart;
import com.example.tillproject.repository.TentativeCartRepository;

@Service
public class TentativeCartService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TentativeCartRepository tentativeCartRepository;
	
	void updateList() {
		
	}
	public void addToTentativeCartList(TentativeCartDTO cartItems) {
			TentativeCart tentativeCart=modelMapper.map(cartItems,TentativeCart.class);
			tentativeCart.setTotalPrice(cartItems.getQuantity()*Float.parseFloat(cartItems.getPrice()));
     		tentativeCartRepository.save(tentativeCart);
	}
	public Map<String,Object> getTentativeCartItems(String empId){
		List<TentativeCartDTO> items=getTentativeCartItemsList(empId);
		float PricingTotal=0;
		Map<String, Object> cartList=new TreeMap<String, Object>();
		cartList.put("itemList", items);
		for(TentativeCartDTO data:items) {
			PricingTotal=Float.parseFloat(data.getTotalPrice())+PricingTotal;
		}
		cartList.put("Total", PricingTotal);
		
		return cartList;
		
	}


	private List<TentativeCartDTO> getTentativeCartItemsList(String empId){
		
		List<TentativeCart> tentativecart=tentativeCartRepository.findAllByEmpId(empId);
		List<TentativeCartDTO> tentativeCartList=new ArrayList<TentativeCartDTO>();
		for(TentativeCart itemDTO:tentativecart) {
			TentativeCartDTO tentativeCart=modelMapper.map(itemDTO,TentativeCartDTO.class);
			tentativeCartList.add(tentativeCart);
		}

		return tentativeCartList;
		
	}
}
