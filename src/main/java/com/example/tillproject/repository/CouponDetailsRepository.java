package com.example.tillproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tillproject.model.CouponDetails;

public interface CouponDetailsRepository extends JpaRepository<CouponDetails,Long>{

	CouponDetails findByCouponCode(String couponCode);

}
