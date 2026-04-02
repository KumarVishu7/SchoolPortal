package com.SchoolPortal.Portal.Service;

import com.SchoolPortal.Portal.DTO.HomeworkDto;

public interface HomeworkService {

    void createHomework(HomeworkDto dto, Long teacherId);
}
