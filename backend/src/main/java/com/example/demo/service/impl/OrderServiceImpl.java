package com.example.demo.service.impl;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.OrderProductsRequestDto;
import com.example.demo.dto.OrderRequestDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderProducts;
import com.example.demo.entity.Product;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<CommonResponse> placeOrder(OrderRequestDto requestDto) {
        CommonResponse response = new CommonResponse();
        try {
            Customer customer = customerRepository.findById(requestDto.getCustomerId())
                    .orElseThrow(()-> new RuntimeException("Customer Not Found With Id :" + requestDto.getCustomerId()));

            Order order = new Order();
            order.setCustomer(customer);
            order.setOrderDate(LocalDateTime.now());
            order.setTotalAmount(BigDecimal.ZERO);

            List<OrderProducts> orderProductsList = new ArrayList<>();

                for (OrderProductsRequestDto orderProductsRequestDto:
                        requestDto.getProducts()) {

                Product product = productRepository.findById(orderProductsRequestDto.getProductId())
                        .orElseThrow(()-> new RuntimeException("Product Not Found For This Id: " + orderProductsRequestDto.getProductId()));

                OrderProducts orderProduct = new OrderProducts();

                orderProduct.setOrder(order);
                orderProduct.setProduct(product);
                orderProduct.setQuantity(orderProductsRequestDto.getQuantity());
                orderProduct.setUnitPrice(product.getUnitPrice());
                orderProduct.setTotalPrice(product.getUnitPrice().multiply(BigDecimal.valueOf(orderProductsRequestDto.getQuantity())));

                order.setTotalAmount(order.getTotalAmount().add(orderProduct.getTotalPrice()));

                orderProductsList.add(orderProduct);
            }
            order.setOrderProducts(orderProductsList);
            orderRepository.save(order);
            response.setData(null);
            response.setStatus((HttpStatus.CREATED));
            response.setMessage("order placed successfully");
        }catch (Exception e) {
            response.setData(null);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("order failed");
        }
        return ResponseEntity.ok().body(response);
    }

    public void setOrderProducts(Order order, OrderRequestDto orderRequestDto) {
        if (!orderRequestDto.getProducts().isEmpty()) {
            List<OrderProducts> orderProductsList = new ArrayList<>();

            for (OrderProductsRequestDto productDto : orderRequestDto.getProducts()) {
            OrderProducts orderProducts = new OrderProducts();

            orderProducts.setOrder(order);
            orderProductsList.add(orderProducts);
        }
    }
    }

    public Order setCustomer(Order order, OrderRequestDto orderRequestDto){
//        Order model = new Order();

        if (orderRequestDto.getCustomerId() != null){
            Customer customer = customerRepository.findById(orderRequestDto.getCustomerId())
                    .orElseThrow(()-> new RuntimeException("Customer Not Found With Id :" + orderRequestDto.getCustomerId()));
            order.setCustomer(customer);
        }
        return order;
    }
}
