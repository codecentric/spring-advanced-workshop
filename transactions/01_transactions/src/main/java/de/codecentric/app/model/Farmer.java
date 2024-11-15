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
    private Long id;

    private String firstName;
    private String lastName;
}
