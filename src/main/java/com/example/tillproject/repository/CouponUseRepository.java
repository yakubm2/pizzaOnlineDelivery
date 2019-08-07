package com.example.tillproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tillproject.model.CouponUse;

public interface CouponUseRepository extends JpaRepository<CouponUse,Long>{

	@Query("select c from CouponUse c where c.empId=?1 and used = false")
	CouponUse findAllByempIdId(String empId);

}
