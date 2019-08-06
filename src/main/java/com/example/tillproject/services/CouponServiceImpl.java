package com.example.tillproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tillproject.dto.TentativeCartDTO;
import com.example.tillproject.model.Coupon;
import com.example.tillproject.model.CouponDetails;
import com.example.tillproject.repository.CouponDetailsRepository;
import com.example.tillproject.util.CouponType;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponDetailsRepository couponDetails;
	@Override
	public void calculateDiscount(List<TentativeCartDTO> items, Coupon coupon) {
		// TODO Auto-generated method stub
		CouponDetails details=couponDetails.findByCouponCode(coupon.getCouponCode());
		boolean discount=false;
		if(details.getType().equals(CouponType.DISCOUNTOFFER)) {
			discount=true;
		}
		int quantity=0;
		for(TentativeCartDTO product:items) {
			if(discount==true) {
				//logic for discount
			}
			if(discount=false&&details.getMinQuantity()<=product.getQuantity()) {
				//logic for quantity
			}
			
		}
	}

}