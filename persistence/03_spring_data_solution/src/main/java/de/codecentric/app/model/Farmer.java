package de.codecentric.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// Lösung 1.1
@Table(name = "Farmers")
public class Farmer {

    // Lösung 1.1
    @GeneratedValue
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
