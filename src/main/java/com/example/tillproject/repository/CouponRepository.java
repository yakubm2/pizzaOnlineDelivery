package com.example.tillproject.repository;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tillproject.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Long>{

	@Query("select c from Coupon c where c.empId=?1")
	List<Coupon> findAllByEmpId(String empId);

	@Query("Select c from Coupon c where c.empId=?1 and c.productId IN ?2 ")
	List<Coupon> findAllByEmpIdAndProductId(String empId, HashSet productList);

}
