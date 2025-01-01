package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.SupplierDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public SupplierDto modelToDto(Supplier model) {
        SupplierDto dto = new SupplierDto();
        if (model == null) {
            return null;
        }
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        dto.setContactNumber(model.getContactNumber());

        return  dto;
    }
}
