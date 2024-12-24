package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.OrderRequestDto;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<CommonResponse> createOrder(@RequestBody OrderRequestDto requestDto){
        return orderService.placeOrder(requestDto);
    }
}
