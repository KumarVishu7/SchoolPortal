package com.SchoolPortal.Portal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "classrooms")
public class ClassRoom extends BaseEntity {

    @Column(unique = true)
    private String className; // 10A, 9B
}
