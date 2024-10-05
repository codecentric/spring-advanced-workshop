package de.codecentric.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FARMERS")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = Farmer.QUERY_FIND_ALL, query = "SELECT f FROM de.codecentric.app.model.Farmer AS f"),
        @NamedQuery(name = Farmer.QUERY_FIND_BY_LASTNAME, query = "SELECT f FROM de.codecentric.app.model.Farmer AS f WHERE lastname = :lastName")
})
public class Farmer {

    public static final String QUERY_FIND_ALL = "Farmer.findAll";
    public static final String QUERY_FIND_BY_LASTNAME = "Farmer.findByLastname";
    @GeneratedValue
    @Id
    @Column(name = "FARMER_ID")
    private Long id;

    @Column(name = "FARMER_FIRSTNAME")
    private String firstname;
    @Column(name = "FARMER_LASTNAME")
    private String lastname;
}
