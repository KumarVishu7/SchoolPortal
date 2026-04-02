package com.SchoolPortal.Portal.Controller;

import com.SchoolPortal.Portal.DTO.ClassRoomDto;
import com.SchoolPortal.Portal.Service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassRoomController {

    private final ClassRoomService service;

    @PostMapping
    public String create(@RequestBody ClassRoomDto dto) {
        service.createClass(dto);
        return "Class created";
    }
}
