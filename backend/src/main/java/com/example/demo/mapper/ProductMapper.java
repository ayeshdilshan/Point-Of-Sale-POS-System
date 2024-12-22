package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductMapper {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public Product dtoToModel(ProductDto dto) {
        Product model = new Product();
        if(dto == null) {
            return null;
        }

        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setUnitPrice(dto.getUnitPrice());
        model.setStockLevel(dto.getStockLevel());

        if (dto.getCategoryId() != null){
            ProductCategory category = productCategoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(()-> new RuntimeException("Product Category Not Found With Id :" + dto.getCategoryId()));
            model.setCategory(category);
        }

        if (dto.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                    .orElseThrow(()-> new RuntimeException("Product Supplier Not Found With Id :" + dto.getSupplierId()));
            model.setSupplier(supplier);
        }

        return  model;
    }

    public ProductDto modelToDto (Product model) {
        ProductDto dto = new ProductDto();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setStockLevel(model.getStockLevel());
        dto.setUnitPrice(model.getUnitPrice());
        dto.setCategoryId(model.getCategory().getId());
        dto.setCategory(model.getCategory());
        dto.setSupplierId(model.getSupplier().getId());

        return dto;
    }
}
