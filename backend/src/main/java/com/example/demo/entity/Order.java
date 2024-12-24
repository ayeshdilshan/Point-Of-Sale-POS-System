package com.example.demo.entity;

import com.example.demo.enums.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "ordered_customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProducts> orderProducts;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderProducts(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
