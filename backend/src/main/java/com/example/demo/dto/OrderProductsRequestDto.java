package com.example.demo.dto;

public class OrderProductsRequestDto {

    private Long productId;

    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
