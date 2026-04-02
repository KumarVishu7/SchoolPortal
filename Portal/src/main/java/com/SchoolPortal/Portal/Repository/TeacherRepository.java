package com.SchoolPortal.Portal.Repository;

import com.SchoolPortal.Portal.Entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }
}
