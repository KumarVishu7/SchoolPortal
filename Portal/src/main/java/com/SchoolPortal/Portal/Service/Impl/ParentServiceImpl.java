package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.ParentDto;
import com.SchoolPortal.Portal.Entity.Parent;
import com.SchoolPortal.Portal.Entity.User;
import com.SchoolPortal.Portal.Repository.ParentRepository;
import com.SchoolPortal.Portal.Service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository repository;

    @Override
    public void createParent(ParentDto dto) {
        Parent p = new Parent();

        User user = new User();
        user.setId(dto.getUserId());

        p.setUser(user);
        repository.save(p);
    }
}
