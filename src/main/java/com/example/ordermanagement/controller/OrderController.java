package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")


public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public Page<Order> getOrders(
            @RequestParam(required = false) String orderId,
            @RequestParam(required = false) String customer,
            @RequestParam(required = false) String orderItem,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) List<String> status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return orderService.findFilteredOrders(orderId, customer, orderItem, from, to, minPrice, maxPrice, status, page, size);
    }
}