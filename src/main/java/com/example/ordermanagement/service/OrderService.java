package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<Order> findFilteredOrders(String orderId, String customer, String orderItem,
                                          String from, String to, Double minPrice, Double maxPrice,
                                          List<String> status, int page, int size) {

        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (orderId != null && !orderId.trim().isEmpty()) {
            criteriaList.add(Criteria.where("orderId").regex(orderId, "i"));
        }
        if (customer != null && !customer.trim().isEmpty()) {
            criteriaList.add(Criteria.where("customer").regex(customer, "i"));
        }
        if (orderItem != null && !orderItem.trim().isEmpty()) {
            criteriaList.add(Criteria.where("orderItem").regex(orderItem, "i"));
        }
        if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {
            criteriaList.add(Criteria.where("deliveryDate").gte(LocalDate.parse(from)).lte(LocalDate.parse(to)));
        }
        if (minPrice != null) {
            criteriaList.add(Criteria.where("deliveryPricing").gte(minPrice));
        }
        if (maxPrice != null) {
            criteriaList.add(Criteria.where("deliveryPricing").lte(maxPrice));
        }
        if (status != null && !status.isEmpty()) {
            criteriaList.add(Criteria.where("status").in(status));
        }

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        long count = mongoTemplate.count(query, Order.class);

        PageRequest pageable = PageRequest.of(page, size);
        query.with(pageable);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return new PageImpl<>(orders, pageable, count);
    }
}
