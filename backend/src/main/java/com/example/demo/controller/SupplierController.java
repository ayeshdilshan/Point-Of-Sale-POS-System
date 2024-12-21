package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.SupplierDto;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createSupplier ( @RequestBody SupplierDto supplierDto) {
        return supplierService.createSupplier(supplierDto);
    }
}
