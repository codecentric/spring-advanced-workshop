package de.codecentric.app.repository;

import de.codecentric.app.model.Farmer;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FarmerRepository {

    // TODO
    private EntityManager em;

    public Farmer findByLastName(String name) {
        // TODO
        return null;
    }

    public List<Farmer> findAll() {
        // TODO (@SuppressWarnings("unchecked") könnte notwendig sein)
        return null;
    }

}
