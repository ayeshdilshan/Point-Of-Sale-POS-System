package com.example.demo.mapper;

import com.example.demo.dto.OrderRequestDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    private CustomerRepository customerRepository;

    public Order dtoToModel(Order order , OrderRequestDto orderRequestDto) {
        Order model = new Order();

        if (orderRequestDto.getCustomerId() != null){
            Customer customer = customerRepository.findById(orderRequestDto.getCustomerId())
                    .orElseThrow(()-> new RuntimeException("Customer Not Found With Id :" + orderRequestDto.getCustomerId()));
            model.setCustomer(customer);
        }
        return model;
    }
}
