package com.example.ordermanagement.config;


import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(OrderRepository repo) {
        return args -> {
            repo.deleteAll(); // Clear existing data
            repo.saveAll(List.of(
                    new Order(null, "ORD001", "Alice Smith", "Laptop", LocalDate.now().minusDays(5), 1200.50, "Completed"),
                    new Order(null, "ORD002", "Bob Johnson", "Keyboard", LocalDate.now().minusDays(2), 75.00, "Continuing"),
                    new Order(null, "ORD003", "Charlie Brown", "Mouse", LocalDate.now().minusDays(10), 25.99, "Canceled"),
                    new Order(null, "ORD004", "Diana Prince", "Monitor", LocalDate.now().plusDays(1), 300.00, "Restitute"),
                    new Order(null, "ORD005", "Alice Smith", "Webcam", LocalDate.now(), 89.99, "Continuing"),
                    new Order(null, "ORD006", "Ethan Hunt", "Docking Station", LocalDate.now().minusDays(20), 150.00, "Completed"),
                    new Order(null, "ORD007", "Frank Castle", "USB Hub", LocalDate.now().minusDays(3), 22.50, "Canceled"),
                    new Order(null, "ORD008", "Grace Hopper", "Printer", LocalDate.now().plusDays(5), 250.00, "Continuing"),
                    new Order(null, "ORD009", "Hank Pym", "Antivirus Software", LocalDate.now().minusDays(8), 49.99, "Completed"),
                    new Order(null, "ORD010", "Ivy Pepper", "Headphones", LocalDate.now(), 199.99, "Restitute"),
                    new Order(null, "ORD011", "Jack Ryan", "External HDD", LocalDate.now().minusDays(1), 120.00, "Continuing"),
                    new Order(null, "ORD012", "Kara Danvers", "Laptop Stand", LocalDate.now().minusDays(30), 45.50, "Completed")
            ));
        };
    }
}
