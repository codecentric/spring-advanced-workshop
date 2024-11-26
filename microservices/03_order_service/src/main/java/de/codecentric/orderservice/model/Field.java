package de.codecentric.orderservice.model;

import lombok.Data;

@Data
public class Field {
    private Long id;
    private String name;
    private String cropType;
    private Double area;
}
