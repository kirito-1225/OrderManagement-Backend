package com.example.ordermanagement.repository;


import com.example.ordermanagement.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // custom query methods (if needed)
    List<Order> findByCustomerContainingIgnoreCase(String customer);
    List<Order> findByOrderItemContainingIgnoreCase(String orderItem);
    List<Order> findByDeliveryDateBetween(LocalDate from, LocalDate to);
    List<Order> findByDeliveryPricingBetween(double min, double max);
    List<Order> findByStatusIn(List<String> statuses);
}
