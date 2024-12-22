package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public ResponseEntity<CommonResponse> saveCustomer(CustomerDto customerDto) {
        CommonResponse response = new CommonResponse();
        try {
            Customer customer = new Customer();
            if (customerDto != null) {
                customer.setName(customerDto.getCustomerName());
                Customer savedCustomer = customerRepository.save(customer);
                response.setData(savedCustomer);
                response.setStatus(HttpStatus.CREATED);
                response.setMessage("Customer saved successfully");
            }
        }
        catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Customer saved failed");
        }
        return ResponseEntity.ok().body(response);
    }
}
