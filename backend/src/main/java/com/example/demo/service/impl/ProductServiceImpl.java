package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<CommonResponse> createProduct(ProductDto productDto) {
        CommonResponse response = new CommonResponse();
        try {
            Product product = productMapper.dtoToModel(productDto);
            productRepository.save(product);
            response.setData(product);
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Product Saved Successfully");
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<CommonResponse> getAllProducts() {
        CommonResponse response = new CommonResponse();
        List<ProductDto> productDtos =new ArrayList<>();
        try {
            List<Product> products = productRepository.findAll();

            productDtos = products.stream()
                    .map(productMapper::modelToDto)
                    .collect(Collectors.toList());

            response.setData(productDtos);
            response.setStatus(HttpStatus.FOUND);
            response.setMessage("Products Found Successfully");
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Products Not Found");
        }
        System.out.println("Response: " + response); // Verify response object
        return ResponseEntity.ok(response);
    }
}
