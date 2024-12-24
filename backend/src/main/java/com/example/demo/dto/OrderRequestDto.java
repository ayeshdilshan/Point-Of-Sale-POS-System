package com.example.demo.dto;

import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestDto {

    private Integer customerId;

    private List<OrderProductsRequestDto> orderProductsRequestDtoList = new ArrayList<>();

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderProductsRequestDto> getProducts() {
        return orderProductsRequestDtoList;
    }

    public void setProducts(List<OrderProductsRequestDto> orderProductsRequestDtoList) {
        this.orderProductsRequestDtoList = orderProductsRequestDtoList;
    }

    public List<OrderProductsRequestDto> getOrderProductsRequestDtoList() {
        return orderProductsRequestDtoList;
    }

    public void setOrderProductsRequestDtoList(List<OrderProductsRequestDto> orderProductsRequestDtoList) {
        this.orderProductsRequestDtoList = orderProductsRequestDtoList;
    }
}
