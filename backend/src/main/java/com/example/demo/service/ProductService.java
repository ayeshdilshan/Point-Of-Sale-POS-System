package com.example.demo.service;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {

   ResponseEntity<CommonResponse> createProduct(ProductDto productDto);

   ResponseEntity<CommonResponse> getAllProducts();

   ResponseEntity<CommonResponse> getProductsByCategoryName(String categoryName);

   ResponseEntity<CommonResponse> getTop5MostExpensiveProducts();
}
