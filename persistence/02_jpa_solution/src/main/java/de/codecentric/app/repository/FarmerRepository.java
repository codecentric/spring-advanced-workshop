package de.codecentric.app.repository;

import de.codecentric.app.model.Farmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FarmerRepository {

    @PersistenceContext
    private EntityManager em;

    public Farmer findByLastName(String name) {
        Farmer farmer;
        try {
            farmer = (Farmer) this.em.createNamedQuery(Farmer.QUERY_FIND_BY_LASTNAME).setParameter("lastName", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return farmer;
    }

    public List<Farmer> findAll() {
        @SuppressWarnings("unchecked")
        List<Farmer> result = this.em.createNamedQuery(Farmer.QUERY_FIND_ALL).getResultList();
        return result;
    }

}
