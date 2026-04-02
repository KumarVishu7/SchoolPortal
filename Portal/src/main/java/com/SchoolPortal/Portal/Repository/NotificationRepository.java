package com.SchoolPortal.Portal.Repository;

import com.SchoolPortal.Portal.Entity.Notification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Notification notification) {
        entityManager.persist(notification);
    }

    public List<Notification> findByUserId(Long userId) {

        String sql = """
            SELECT * FROM notification 
            WHERE user_id = :userId
        """;

        return entityManager.createNativeQuery(sql, Notification.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
