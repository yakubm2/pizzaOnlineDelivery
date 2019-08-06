package com.example.tillproject.services;

import java.util.List;

import com.example.tillproject.dto.TentativeCartDTO;
import com.example.tillproject.model.Coupon;

public interface CouponService {
void calculateDiscount(List<TentativeCartDTO> items,Coupon coupon);



}
