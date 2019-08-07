package com.example.tillproject.services;

import java.util.Map;

public interface CouponService {
Map<String, Object> calculateDiscount(Map<String, Object> cartList,String couponUse);



}
