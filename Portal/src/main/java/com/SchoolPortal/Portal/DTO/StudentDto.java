package com.SchoolPortal.Portal.DTO;

import lombok.Data;

@Data
public class StudentDto {
    private String studentName;
    private Long classId;
    private Long parentId;
    private String parentName;
    private Long mobileNo;
}