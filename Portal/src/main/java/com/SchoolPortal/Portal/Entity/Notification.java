package com.SchoolPortal.Portal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Column(length = 500)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isRead = false;
}
