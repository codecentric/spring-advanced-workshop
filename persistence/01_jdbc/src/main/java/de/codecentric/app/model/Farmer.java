package de.codecentric.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FARMERS")
@Getter
@Setter
public class Farmer {

    @GeneratedValue
    @Id
    @Column(name = "FARMER_ID")
    private Long id;

    @Column(name = "FARMER_FIRSTNAME")
    private String firstName;
    @Column(name = "FARMER_LASTNAME")
    private String lastName;
}
