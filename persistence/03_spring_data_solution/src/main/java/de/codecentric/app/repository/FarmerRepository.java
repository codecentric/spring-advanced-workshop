package de.codecentric.app.repository;

import de.codecentric.app.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Lösung 2.1
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    // Lösung 2.2
    Farmer findByLastName(String lastName);
}
