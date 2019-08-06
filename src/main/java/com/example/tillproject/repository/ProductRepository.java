package com.example.tillproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tillproject.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	

}
