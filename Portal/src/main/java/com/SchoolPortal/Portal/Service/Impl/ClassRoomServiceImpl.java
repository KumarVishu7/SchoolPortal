package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.ClassRoomDto;
import com.SchoolPortal.Portal.Entity.ClassRoom;
import com.SchoolPortal.Portal.Repository.ClassRoomRepository;
import com.SchoolPortal.Portal.Service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository repository;

    @Override
    public void createClass(ClassRoomDto dto) {
        ClassRoom c = new ClassRoom();
        c.setClassName(dto.getClassName());
        repository.save(c);
    }
}
