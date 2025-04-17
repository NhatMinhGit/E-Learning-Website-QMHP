package org.example.elearning_website_qmhp.backend.controllers;

import org.example.elearning_website_qmhp.backend.dto.CoursesDto;
import org.example.elearning_website_qmhp.backend.models.Courses;
import org.example.elearning_website_qmhp.backend.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/courses-list")
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses-list")
    public String showCoursesList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                  Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Courses> coursesList = coursesService.findAllCourses(pageable);
        model.addAttribute("coursesList", coursesList);
        return "courses-list";
    }

    @GetMapping("/show-add-courses-page")
    public String showAddCoursesPage(Model model) {
        CoursesDto coursesDto = new CoursesDto();
        model.addAttribute("coursesDto", coursesDto);
        return "add-courses-page";
    }

    @GetMapping("/show-edit-course/{id}")
    public String showEditCoursePage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("course", coursesService.findCoursesById(id));
        return "edit-course-page";
    }
}
