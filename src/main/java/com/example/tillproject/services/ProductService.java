package com.example.tillproject.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tillproject.dto.ProductDTO;
import com.example.tillproject.model.Product;
import com.example.tillproject.repository.ProductRepository;

@Service
public class ProductService {

@Autowired
ModelMapper modelMapper;
@Autowired
ProductRepository productRepository;

	public List<ProductDTO> getProductList() {
		List<ProductDTO> responseproduct=new ArrayList<ProductDTO>();
		// TODO Auto-generated method stub
		for(Product product:productRepository.findAll()) {
			
			ProductDTO orderDTO = modelMapper.map(product, ProductDTO.class);
		
			responseproduct.add(orderDTO);
		}
		return responseproduct;
	}

}
