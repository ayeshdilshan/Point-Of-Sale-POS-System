package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createReceipt( @RequestBody ProductDto dto) {
        return productService.createProduct(dto);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<CommonResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
