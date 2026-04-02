package com.SchoolPortal.Portal.Repository;
import com.SchoolPortal.Portal.Entity.ClassRoom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(ClassRoom c) {
        entityManager.persist(c);
    }

    public List<ClassRoom> findAll() {
        String sql = "SELECT * FROM classrooms";
        return entityManager.createNativeQuery(sql, ClassRoom.class)
                .getResultList();
    }
}
