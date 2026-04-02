package com.SchoolPortal.Portal.Controller;

import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.StudentDto;
import com.SchoolPortal.Portal.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public String create(@RequestBody StudentDto dto) {
        service.createStudent(dto);
        return "Student added";
    }

    @GetMapping("/getAll")
    public ResponseEntity<PageResponse<StudentDto>> getAllStudent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        PageResponse<StudentDto> list=service.getAllStudent(page, size);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
