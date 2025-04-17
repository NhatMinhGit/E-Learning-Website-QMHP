package org.example.elearning_website_qmhp.backend.services.serviceimpl;

import org.example.elearning_website_qmhp.backend.models.Courses;
import org.example.elearning_website_qmhp.backend.repositories.ICoursesRepository;
import org.example.elearning_website_qmhp.backend.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private ICoursesRepository coursesRepository;

    @Override
    public Page<Courses> findAllCourses(Pageable pageable) {
        return coursesRepository.findAllCourses((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public void saveCourses(Courses courses) {
        coursesRepository.save(courses);
    }

    @Override
    public Courses findCoursesById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCoursesById(Long id) {
        coursesRepository.deleteById(id);
    }
}
