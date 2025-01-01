package com.example.demo.service;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.SupplierDto;
import org.springframework.http.ResponseEntity;

public interface SupplierService {

    ResponseEntity<CommonResponse> createSupplier(SupplierDto dto);

    ResponseEntity<CommonResponse> getSuppliersByProductName(String productName);
}
