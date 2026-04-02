package com.SchoolPortal.Portal.Repository;

import com.SchoolPortal.Portal.DTO.StudentDto;
import com.SchoolPortal.Portal.Entity.Student;
import com.SchoolPortal.Portal.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    public List<StudentDto> getAllStudent(int page, int size) {
        String sql = "SELECT st.student_name, st.class_id, st.parent_id, us.user_name, pt.mobile_No " +
                "FROM student AS st " +
                "JOIN parent AS pt ON st.parent_id = pt.id " +
                "JOIN users AS us ON us.id = pt.user_id";

        List<Object[]> results = entityManager.createNativeQuery(sql)
                .setFirstResult(page * size)   // OFFSET
                .setMaxResults(size)           // LIMIT
                .getResultList();

        // Mapping Object[] → StudentDto
        return results.stream().map(obj -> {
            StudentDto dto = new StudentDto();
            dto.setStudentName((String) obj[0]);
            dto.setClassId(obj[1] != null ? ((Number) obj[1]).longValue() : null);
            dto.setParentId(obj[2] != null ? ((Number) obj[2]).longValue() : null);
            dto.setParentName((String) obj[3]);
            dto.setMobileNo((Long) obj[4]);
            return dto;
        }).toList();
    }

    public List<Student> findByClassId(Long classId) {

        String sql = """
            SELECT * FROM student 
            WHERE class_id = :classId
        """;

        return entityManager.createNativeQuery(sql, Student.class)
                .setParameter("classId", classId)
                .getResultList();
    }

    public List<Student> findByParentId(Long parentId) {

        String sql = """
            SELECT * FROM student 
            WHERE parent_id = :parentId
        """;

        return entityManager.createNativeQuery(sql, Student.class)
                .setParameter("parentId", parentId)
                .getResultList();
    }
    public Long countAll() {
        String countSql = "SELECT COUNT(*) FROM student";
        return ((Number) entityManager.createNativeQuery(countSql).getSingleResult()).longValue();
    }
}
