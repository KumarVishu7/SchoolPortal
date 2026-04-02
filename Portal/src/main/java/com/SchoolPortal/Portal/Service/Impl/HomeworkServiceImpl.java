package com.SchoolPortal.Portal.Service.Impl;
import com.SchoolPortal.Portal.DTO.HomeworkDto;
import com.SchoolPortal.Portal.Entity.*;
import com.SchoolPortal.Portal.Repository.HomeworkRepository;
import com.SchoolPortal.Portal.Repository.NotificationRepository;
import com.SchoolPortal.Portal.Repository.StudentRepository;
import com.SchoolPortal.Portal.Repository.TeacherClassRepository;
import com.SchoolPortal.Portal.Service.HomeworkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final TeacherClassRepository teacherClassRepository;
    private final StudentRepository studentRepository;
    private final NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void createHomework(HomeworkDto dto, Long teacherId) {

        // 1. Validate teacher access
        boolean allowed = teacherClassRepository
                .existsByTeacherAndClass(teacherId, dto.getClassId());

        if (!allowed) {
            throw new RuntimeException("You are not allowed for this class");
        }

        // 2. Create Homework
        Homework homework = new Homework();
        homework.setTitle(dto.getTitle());
        homework.setDescription(dto.getDescription());

        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(dto.getClassId());
        homework.setClassRoom(classRoom);

        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        homework.setTeacher(teacher);

        homeworkRepository.save(homework);

        // 3. Fetch Students
        List<Student> students = studentRepository.findByClassId(dto.getClassId());

        // 4. Send Notification to Parents
        for (Student student : students) {

            User parentUser = student.getParent().getUser();

            Notification notification = new Notification();
            notification.setUser(parentUser);
            notification.setMessage("New homework assigned: " + dto.getTitle());

            notificationRepository.save(notification);
        }
    }
}