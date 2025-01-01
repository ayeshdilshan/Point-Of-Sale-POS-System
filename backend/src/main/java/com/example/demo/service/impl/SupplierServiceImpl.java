package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.SupplierDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Supplier;
import com.example.demo.mapper.SupplierMapper;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public ResponseEntity<CommonResponse> createSupplier(SupplierDto dto) {
        CommonResponse response = new CommonResponse();

        try {
            Supplier supplier = new Supplier();
            if (dto != null) {
                supplier.setName(dto.getName());
                supplier.setContactNumber(dto.getContactNumber());
                supplier.setEmail(dto.getEmail());
                Supplier savedSupplier = supplierRepository.save(supplier);
                response.setData(savedSupplier);
                response.setStatus(HttpStatus.CREATED);
                response.setMessage("Supplier saved successfully");
            }
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Supplier save failed");
        }
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<CommonResponse> getSuppliersByProductName(String productName) {
        CommonResponse response = new CommonResponse();
        List<SupplierDto> supplierDtoList;
        try {
            List<Supplier> suppliers = supplierRepository.findSuppliersByProductName(productName);

            supplierDtoList = suppliers.stream()
                    .map(supplierMapper::modelToDto)
                    .collect(Collectors.toList());


            response.setData(supplierDtoList);
            response.setStatus(HttpStatus.FOUND);
            response.setMessage("Products Found Successfully");
        } catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Products Not Found");
        }
        return ResponseEntity.ok(response);
    }
}
