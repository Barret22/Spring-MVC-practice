package com.example.orders.controller;

import com.example.orders.model.Order;
import com.example.orders.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    // 5.2 Отримання конкретного замовлення
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5.3 Отримання всіх замовлень
    @GetMapping
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    // 5.4 Додавання нового замовлення
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = repository.save(order);
        return ResponseEntity.ok(savedOrder);
    }
}
