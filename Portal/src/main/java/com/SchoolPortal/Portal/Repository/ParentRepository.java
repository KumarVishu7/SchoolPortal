package com.SchoolPortal.Portal.Repository;

import com.SchoolPortal.Portal.Entity.Parent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ParentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Parent parent) {
        entityManager.persist(parent);
    }
}
