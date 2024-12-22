package com.example.demo.dto;

import com.example.demo.entity.ProductCategory;
import lombok.*;

@Data
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private double unitPrice;
    private int stockLevel;
    private Long categoryId;
    private Long supplierId;
    private ProductCategory category;



    // Getters and setters
    public  void setId(Long id) {this.productId = id;}
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
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

    public ProductCategory getProductCategory() {
        return category;
    }

    public void setCategory (ProductCategory category) {
        this.category = category;
    }

    public void setCategoryId(Long id ) {
        this.categoryId = id;
    }

    public Long getSupplierId() {return supplierId;}

    public void setSupplierId(Long id ) {
        this.supplierId = id;
    }
}
