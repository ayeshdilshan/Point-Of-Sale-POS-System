package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;
@Component
public class ProductMapper {

    public Product dtoToModel(ProductDto dto) {
        Product model = new Product();
        if(dto == null) {
            return null;
        }

        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setUnitPrice(dto.getUnitPrice());
        model.setStockLevel(dto.getStockLevel());

        return  model;
    }
}
