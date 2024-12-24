package com.example.demo.service;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.OrderRequestDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<CommonResponse> placeOrder(OrderRequestDto requestDto);
}
