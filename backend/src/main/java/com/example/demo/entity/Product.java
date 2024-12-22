package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "stock_level")
    private int stockLevel;

    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)
    private ProductCategory category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProducts> orderProducts = new ArrayList<>();

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    // Getters

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public ProductCategory getCategory() {
        return category;
    }

}
