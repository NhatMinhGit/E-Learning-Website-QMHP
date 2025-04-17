package org.example.elearning_website_qmhp.backend.services;

import org.example.elearning_website_qmhp.backend.models.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoursesService {
    Page<Courses> findAllCourses(Pageable pageable);
    void saveCourses(Courses courses);
    Courses findCoursesById(Long id);
    void deleteCoursesById(Long id);
}
