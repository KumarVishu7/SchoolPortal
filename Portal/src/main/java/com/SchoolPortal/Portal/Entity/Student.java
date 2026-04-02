package com.SchoolPortal.Portal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student extends BaseEntity {

    @Column(name = "student_name")
    private String student_name;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
