package com.example.ordermanagement.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String orderId;
    private String customer;
    private String orderItem;
    private LocalDate deliveryDate;
    private double deliveryPricing;
    private String status;

    public Order() {
    }

    public Order(String id, String orderId, String customer, String orderItem,
                 LocalDate deliveryDate, double deliveryPricing, String status) {
        this.id = id;
        this.orderId = orderId;
        this.customer = customer;
        this.orderItem = orderItem;
        this.deliveryDate = deliveryDate;
        this.deliveryPricing = deliveryPricing;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getDeliveryPricing() {
        return deliveryPricing;
    }

    public void setDeliveryPricing(double deliveryPricing) {
        this.deliveryPricing = deliveryPricing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
