package de.codecentric.orderservice.controller;

import de.codecentric.orderservice.client.FieldClient;
import de.codecentric.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final FieldClient fieldClient;

    public OrderController(OrderRepository orderRepository, FieldClient fieldClient) {
        this.orderRepository = orderRepository;
        this.fieldClient = fieldClient;
    }

    // TODO
}
