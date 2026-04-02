package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.StudentDto;
import com.SchoolPortal.Portal.DTO.UserResponseDto;
import com.SchoolPortal.Portal.Entity.ClassRoom;
import com.SchoolPortal.Portal.Entity.Parent;
import com.SchoolPortal.Portal.Entity.Student;
import com.SchoolPortal.Portal.Entity.User;
import com.SchoolPortal.Portal.Repository.StudentRepository;
import com.SchoolPortal.Portal.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void createStudent(StudentDto dto) {

        Student s = new Student();
        s.setStudent_name(dto.getStudentName());

        ClassRoom c = new ClassRoom();
        c.setId(dto.getClassId());

        Parent p = new Parent();
        p.setId(dto.getParentId());

        s.setClassRoom(c);
        s.setParent(p);

        studentRepository.save(s);
    }

    @Override
    public PageResponse<StudentDto> getAllStudent(int page, int size) {

        List<StudentDto> dtos = studentRepository.getAllStudent(page, size);
        Long total = studentRepository.countAll();

        PageResponse<StudentDto> response = new PageResponse<>();
        response.setContent(dtos);
        response.setPage(page);
        response.setSize(size);
        response.setTotalElements(total);
        response.setTotalPages((int) Math.ceil((double) total / size));

        return response;
    }
    private StudentDto mapToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setStudentName(student.getStudent_name());
        return dto;
    }

}
