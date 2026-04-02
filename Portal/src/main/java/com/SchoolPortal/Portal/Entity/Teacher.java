package com.SchoolPortal.Portal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
