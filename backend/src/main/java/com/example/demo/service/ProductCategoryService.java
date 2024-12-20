package com.example.demo.service;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductCategoryDto;
import org.springframework.http.ResponseEntity;

public interface ProductCategoryService {

    ResponseEntity<CommonResponse> createCategory (ProductCategoryDto dto);

}
