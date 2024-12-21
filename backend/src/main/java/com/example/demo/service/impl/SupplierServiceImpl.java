package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.SupplierDto;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

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
}
