package de.codecentric.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Lösung 2.3
    private String productName;
    private Long productId;
    private int quantity;
}
