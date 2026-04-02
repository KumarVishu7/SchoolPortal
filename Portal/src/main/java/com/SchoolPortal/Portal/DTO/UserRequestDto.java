package com.SchoolPortal.Portal.DTO;

import com.SchoolPortal.Portal.Entity.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
