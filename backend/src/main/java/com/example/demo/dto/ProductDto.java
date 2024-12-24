package com.example.demo.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int stockLevel;
    private Long categoryId;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
