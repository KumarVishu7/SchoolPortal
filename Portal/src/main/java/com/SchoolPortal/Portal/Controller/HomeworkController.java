package com.SchoolPortal.Portal.Controller;

import com.SchoolPortal.Portal.DTO.HomeworkDto;
import com.SchoolPortal.Portal.Service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    // Assume teacherId coming from JWT (for now passing manually)
    @PostMapping("/{teacherId}")
    public ResponseEntity<String> createHomework(
            @RequestBody HomeworkDto dto,
            @PathVariable Long teacherId) {

        homeworkService.createHomework(dto, teacherId);

        return ResponseEntity.ok("Homework created successfully");
    }
}
