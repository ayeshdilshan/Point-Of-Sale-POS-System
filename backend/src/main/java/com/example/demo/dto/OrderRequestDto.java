package com.example.demo.dto;

import com.example.demo.entity.Product;

import java.util.List;

public class OrderRequestDto {

    private Integer customerId;

    private List<ProductDto> products;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
