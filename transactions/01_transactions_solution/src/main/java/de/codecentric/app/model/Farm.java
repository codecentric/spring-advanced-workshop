package de.codecentric.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FARMS")
@Getter
@Setter
public class Farm {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Farmer farmer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

}
