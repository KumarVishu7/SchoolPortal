package com.SchoolPortal.Portal.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {
    private Long userId;
    private List<Long> classIds;
}