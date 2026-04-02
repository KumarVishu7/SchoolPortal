package com.SchoolPortal.Portal.Controller;
import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.UserRequestDto;
import com.SchoolPortal.Portal.DTO.UserResponseDto;
import com.SchoolPortal.Portal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/add")
    public UserResponseDto create(@RequestBody UserRequestDto dto) {
        return service.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id,
                                  @RequestBody UserRequestDto dto) {
        return service.updateUser(id, dto);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping("/getAll")
    public PageResponse<UserResponseDto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.getAllUsers(page, size);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}