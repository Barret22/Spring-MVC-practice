package com.example.orders.repository;

import com.example.orders.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orderStorage = new HashMap<>();
    private Long currentId = 1L;

    // Отримання замовлення по id
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderStorage.get(id));
    }

    // Отримання всіх замовлень
    public List<Order> findAll() {
        return new ArrayList<>(orderStorage.values());
    }

    // Додавання нового замовлення
    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(currentId++);
        }
        orderStorage.put(order.getId(), order);
        return order;
    }
}
