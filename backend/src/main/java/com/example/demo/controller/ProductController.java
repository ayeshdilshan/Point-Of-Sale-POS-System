package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createReceipt( @RequestBody ProductDto dto) {
        return productService.createProduct(dto);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<CommonResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getByCategoryName/{categoryName}")
    public ResponseEntity<CommonResponse> getProductsByCategoryName(@PathVariable("categoryName") String categoryName) {
        return productService.getProductsByCategoryName(categoryName);
    }
}
