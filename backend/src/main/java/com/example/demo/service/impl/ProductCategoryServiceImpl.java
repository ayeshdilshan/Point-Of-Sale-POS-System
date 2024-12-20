package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public ResponseEntity<CommonResponse> createCategory(ProductCategoryDto dto) {
        CommonResponse response = new CommonResponse();

        try {
            ProductCategory productCategory = createNewProdcutCategory(dto);
            productCategoryRepository.save(productCategory);
            response.setData(productCategory);
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Product category saved Successfully");
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }

    private ProductCategory createNewProdcutCategory(ProductCategoryDto dto) {
        ProductCategory productCategory = new ProductCategory();
        if (dto != null) {
            productCategory.setName(dto.getName());
        }
        return productCategory;
    }
}
