package com.SchoolPortal.Portal.Service;

import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.UserRequestDto;
import com.SchoolPortal.Portal.DTO.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto updateUser(Long id, UserRequestDto dto);

    UserResponseDto getUser(Long id);

    PageResponse<UserResponseDto> getAllUsers(int page, int size);

    void deleteUser(Long id);
}
