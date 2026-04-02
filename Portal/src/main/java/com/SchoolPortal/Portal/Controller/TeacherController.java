package com.SchoolPortal.Portal.Controller;

import com.SchoolPortal.Portal.DTO.TeacherDto;
import com.SchoolPortal.Portal.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    public String assign(@RequestBody TeacherDto dto) {
        service.assignTeacher(dto);
        return "Teacher assigned";
    }
}
