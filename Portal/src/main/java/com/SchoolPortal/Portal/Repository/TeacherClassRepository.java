package com.SchoolPortal.Portal.Repository;
import com.SchoolPortal.Portal.Entity.TeacherClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherClassRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(TeacherClass tc) {
        entityManager.persist(tc);
    }

    public boolean existsByTeacherAndClass(Long teacherId, Long classId) {

        String sql = """
            SELECT COUNT(*) 
            FROM teacher_class 
            WHERE teacher_id = :teacherId 
              AND class_id = :classId
        """;

        Number count = (Number) entityManager
                .createNativeQuery(sql)
                .setParameter("teacherId", teacherId)
                .setParameter("classId", classId)
                .getSingleResult();

        return count.intValue() > 0;
    }
}
