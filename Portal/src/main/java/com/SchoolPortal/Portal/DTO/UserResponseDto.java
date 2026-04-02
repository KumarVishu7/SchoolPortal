package com.SchoolPortal.Portal.DTO;

import com.SchoolPortal.Portal.Entity.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private Role role;
}
