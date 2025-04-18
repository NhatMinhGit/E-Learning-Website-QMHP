package org.example.elearning_website_qmhp.backend.controllers;

import org.example.elearning_website_qmhp.backend.dto.CourseEditDto;
import org.example.elearning_website_qmhp.backend.dto.CoursesDto;
import org.example.elearning_website_qmhp.backend.models.Courses;
import org.example.elearning_website_qmhp.backend.services.CoursesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/courses-list")
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses-list")
    public String showCoursesList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                  Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Courses> coursesList = coursesService.findAllCourses(pageable);
        model.addAttribute("coursesList", coursesList);
        return "courses-list";
    }

    @GetMapping("/show-add-course-page")
    public String showAddCoursesPage(Model model) {
        CoursesDto coursesDto = new CoursesDto();
        model.addAttribute("coursesDto", coursesDto);
        return "add-course-page";
    }

    @GetMapping("/show-edit-course/{id}")
    public String showEditCoursePage(@PathVariable(name = "id") Long id, Model model) {
        Courses courses = coursesService.findCoursesById(id);
        CourseEditDto courseEditDto = new CourseEditDto();
        BeanUtils.copyProperties(courses, courseEditDto);
        model.addAttribute("courseEditDto", courseEditDto);
        return "edit-course-page";
    }

    @PostMapping("/add-course")
    public String addCourse(@ModelAttribute("courseDto") CoursesDto coursesDto,
                            RedirectAttributes redirectAttributes) {
        Courses courses = new Courses();
        BeanUtils.copyProperties(coursesDto, courses);
        coursesService.saveCourses(courses);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/courses-list";
    }

    @PostMapping("/edit-course")
    public String editCourse(@ModelAttribute("courseEditDto") CourseEditDto courseEditDto) {
        Courses courses = coursesService.findCoursesById(courseEditDto.getCourseId());
        courses.setTitle(courseEditDto.getTitle());
        courses.setDescription(courseEditDto.getDescription());
        coursesService.saveCourses(courses);
        return "redirect:/courses-list";
    }

    @GetMapping("/courses-list/{id}/delete")
    public String deleteCourse(@PathVariable(name = "id") Long id,
                               RedirectAttributes redirectAttributes) {
        coursesService.deleteCoursesById(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công 1 khóa học!");
        return "redirect:/courses-list";
    }
}
