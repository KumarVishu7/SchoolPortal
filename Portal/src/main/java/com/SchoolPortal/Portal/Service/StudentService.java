package com.SchoolPortal.Portal.Service;

import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.StudentDto;

import java.util.List;

public interface StudentService {
    void createStudent(StudentDto dto);
    PageResponse<StudentDto> getAllStudent(int page, int size);
}
