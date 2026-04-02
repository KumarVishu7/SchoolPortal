package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.PageResponse;
import com.SchoolPortal.Portal.DTO.UserRequestDto;
import com.SchoolPortal.Portal.DTO.UserResponseDto;
import com.SchoolPortal.Portal.Entity.User;
import com.SchoolPortal.Portal.Repository.UserRepository;
import com.SchoolPortal.Portal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        repository.save(user);

        return mapToDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto dto) {

        User user = repository.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        repository.update(user);

        return mapToDto(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {

        User user = repository.findById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return mapToDto(user);
    }

    @Override
    public PageResponse<UserResponseDto> getAllUsers(int page, int size) {

        List<User> users = repository.findAll(page, size);
        Long total = repository.countAll();

        List<UserResponseDto> dtos = users.stream()
                .map(this::mapToDto)
                .toList();

        PageResponse<UserResponseDto> response = new PageResponse<>();
        response.setContent(dtos);
        response.setPage(page);
        response.setSize(size);
        response.setTotalElements(total);
        response.setTotalPages((int) Math.ceil((double) total / size));

        return response;
    }

    @Override
    public void deleteUser(Long id) {
        repository.softDelete(id);
    }

    private UserResponseDto mapToDto(User user) {
        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }
}
