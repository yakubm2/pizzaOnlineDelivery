package com.example.tillproject.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
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

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Map<String, Object> calculateDiscount(Map<String, Object> cartList, String couponUse,
			HashSet<String> productIdList) {
		// TODO Auto-generated method stub
		List<TentativeCartDTO> items = new ArrayList<TentativeCartDTO>();
		items = (List<TentativeCartDTO>) cartList.get("itemList");

		CouponDetails details = couponDetails.findByCouponCode(couponUse);

		if (details.getDiscountType().equalsIgnoreCase(CouponType.DISCOUNTOFFER.toString())) {
			if (productIdList.contains(details.getApplicableProductId())) {
				System.out.println("discounted offer");

			}
	
		} else if (details.getDiscountType().equalsIgnoreCase(CouponType.FREEOFFER.toString())) {
			if (productIdList.contains(String.valueOf(details.getApplicableProductId()))
					&& productIdList.contains(String.valueOf(details.getOfferProductId()))) {
				System.out.println("iterating through list and applying offer");
				if(details.getApplicableProductId()==details.getOfferProductId()) {
					items.forEach(data->{
						System.out.println(String.valueOf(details.getOfferProductId()));
						if(String.valueOf(details.getOfferProductId()).equalsIgnoreCase(data.getProductId())) {
							System.out.println("applying offer on"+data.getProductName()+" :: Rate: "+data.getPrice()+" :: "+data.getPrice()+ " :: "+data.getTotalPrice());
														
						}
					});
				}else {
					
				}
			}
			
		}
		return cartList;
	}

}