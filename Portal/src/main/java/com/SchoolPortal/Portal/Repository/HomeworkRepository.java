package com.SchoolPortal.Portal.Repository;

import com.SchoolPortal.Portal.Entity.Homework;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeworkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Homework homework) {
        entityManager.persist(homework);
    }

    public List<Homework> findByClassId(Long classId) {

        String sql = """
            SELECT * FROM homework 
            WHERE class_id = :classId
        """;

        return entityManager.createNativeQuery(sql, Homework.class)
                .setParameter("classId", classId)
                .getResultList();
    }
}
