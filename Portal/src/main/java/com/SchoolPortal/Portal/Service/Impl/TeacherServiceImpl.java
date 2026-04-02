package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.TeacherDto;
import com.SchoolPortal.Portal.Entity.ClassRoom;
import com.SchoolPortal.Portal.Entity.Teacher;
import com.SchoolPortal.Portal.Entity.TeacherClass;
import com.SchoolPortal.Portal.Entity.User;
import com.SchoolPortal.Portal.Repository.TeacherClassRepository;
import com.SchoolPortal.Portal.Repository.TeacherRepository;
import com.SchoolPortal.Portal.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherClassRepository teacherClassRepository;

    @Override
    public void assignTeacher(TeacherDto dto) {

        Teacher teacher = new Teacher();
        User user = new User();
        user.setId(dto.getUserId());

        teacher.setUser(user);
        teacherRepository.save(teacher);

        // assign classes
        for (Long classId : dto.getClassIds()) {
            TeacherClass tc = new TeacherClass();

            tc.setTeacher(teacher);

            ClassRoom c = new ClassRoom();
            c.setId(classId);

            tc.setClassRoom(c);

            teacherClassRepository.save(tc);
        }
    }
}
