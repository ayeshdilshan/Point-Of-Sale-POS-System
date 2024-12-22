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
            response.setData(productMapper.modelToDto(product));
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Product Saved Successfully");
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }
}
