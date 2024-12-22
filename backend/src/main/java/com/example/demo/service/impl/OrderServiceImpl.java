package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.OrderRequestDto;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ResponseEntity<CommonResponse> placeOrder(OrderRequestDto requestDto) {
        return null;
    }
}
