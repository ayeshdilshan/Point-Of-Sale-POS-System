package com.example.demo.service;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<CommonResponse> saveCustomer(CustomerDto customerDto);
}
