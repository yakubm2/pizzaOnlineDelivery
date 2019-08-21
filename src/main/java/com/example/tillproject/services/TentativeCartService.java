package com.example.tillproject.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tillproject.dto.TentativeCartDTO;
import com.example.tillproject.model.Coupon;
import com.example.tillproject.model.CouponUse;
import com.example.tillproject.model.TentativeCart;
import com.example.tillproject.repository.CouponRepository;
import com.example.tillproject.repository.CouponUseRepository;
import com.example.tillproject.repository.TentativeCartRepository;

@Service
public class TentativeCartService {
	@Autowired
	ModelMapper modelMapper;
		
	@Autowired
	TentativeCartRepository tentativeCartRepository;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	CouponService couponService;
	
	@Autowired
	CouponUseRepository couponUseRepository;
	void updateList() {
		
	}
	public void addToTentativeCartList(TentativeCartDTO cartItems) {
			TentativeCart tentativeCart=modelMapper.map(cartItems,TentativeCart.class);
			tentativeCart.setTotalPrice(cartItems.getQuantity()*Float.parseFloat(cartItems.getPrice()));
     		tentativeCartRepository.save(tentativeCart);
	}
	private List<Coupon> getCoupons(String empId, HashSet<String> productList){
		List<Coupon> couponList=new ArrayList<Coupon>();
		couponList=couponRepository.findAllByEmpIdAndProductId(empId,productList);
	    return couponList;	
	}
	
	public Map<String,Object> getTentativeCartItems(String empId){
		List<TentativeCartDTO> items=getTentativeCartItemsList(empId);
				
		float PricingTotal=0;
		Map<String, Object> cartList=new TreeMap<String, Object>();
		cartList.put("itemList", items);
		HashSet<String> productIdList=new HashSet<String>();
		for(TentativeCartDTO data:items) {
			productIdList.add(data.getProductId());
//			PricingTotal=Float.parseFloat(data.getTotalPrice())+PricingTotal;
		}
//		cartList.put("Total", PricingTotal);
		List<Coupon> couponList=getCoupons(empId,productIdList);
		cartList.put("CouponAvailable",couponList);
		CouponUse couponUse=couponUseRepository.findAllByempIdId(empId);
		
		cartList.put("CouponAdded",couponUse);
		cartList=couponService.calculateDiscount(cartList, couponUse.getCouponCode(),productIdList);
		for(TentativeCartDTO data:items) {
//			productIdList.add(data.getProductId());
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
	public void addCouponToTentativeCartItems(String empId,String couponCode) {
		
		if(couponCode!=null||couponCode!="") {
			
			CouponUse couponUse=couponUseRepository.findAllByempIdId(empId);
			if(couponUse==null) {
				couponUse=new CouponUse();	
			}
			couponUse.setEmpId(empId);
			couponUse.setCouponCode(couponCode);
			couponUse.setUsed(false);
			couponUseRepository.save(couponUse);	
		}
		// TODO Auto-generated method stub
			}
}
