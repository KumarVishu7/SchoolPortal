package com.SchoolPortal.Portal.Repository;
import com.SchoolPortal.Portal.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public User update(User user) {
        return entityManager.merge(user);
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll(int page, int size) {
        String sql = "SELECT * FROM users WHERE is_deleted = false ORDER BY id DESC ";
        return entityManager.createNativeQuery(sql, User.class)
                .setFirstResult(page * size)   // OFFSET
                .setMaxResults(size)           // LIMIT
                .getResultList();
    }

    @Transactional
    public void softDelete(Long id) {
        String sql = """
            UPDATE users  
            SET is_deleted = true 
            WHERE id = :id
        """;

        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();
    }
    public Long countAll() {

        String sql = """
        SELECT COUNT(*) FROM users
        WHERE is_deleted = false
    """;

        return ((Number) entityManager.createNativeQuery(sql)
                .getSingleResult()).longValue();
    }
}
