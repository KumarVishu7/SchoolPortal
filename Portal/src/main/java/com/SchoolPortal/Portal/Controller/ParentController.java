package com.SchoolPortal.Portal.Controller;

import com.SchoolPortal.Portal.DTO.ParentDto;
import com.SchoolPortal.Portal.DTO.StudentDto;
import com.SchoolPortal.Portal.Service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService service;

    @PostMapping("/add")
    public String create(@RequestBody ParentDto dto) {
        service.createParent(dto);
        return "Parent created";
    }

}
