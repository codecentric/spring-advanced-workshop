package de.codecentric.orderservice.controller;

import de.codecentric.orderservice.client.FieldClient;
import de.codecentric.orderservice.model.Field;
import de.codecentric.orderservice.model.Order;
import de.codecentric.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final FieldClient fieldClient;

    public OrderController(OrderRepository orderRepository, FieldClient fieldClient) {
        this.orderRepository = orderRepository;
        this.fieldClient = fieldClient;
    }

    // Lösung 2.4
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Field field = fieldClient.getField(order.getProductId());
        order.setProductName(field.getCropType());
        return orderRepository.save(order);
    }
}
