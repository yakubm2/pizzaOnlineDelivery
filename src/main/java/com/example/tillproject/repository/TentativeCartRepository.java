package com.example.tillproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tillproject.model.TentativeCart;

public interface TentativeCartRepository extends JpaRepository<TentativeCart,String>{

	List<TentativeCart> findAllById(String empId);

	@Query("Select t from TentativeCart t where t.employeeId=?1")
	List<TentativeCart> findAllByEmpId(String empId);

}
