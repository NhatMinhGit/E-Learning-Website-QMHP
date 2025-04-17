package org.example.elearning_website_qmhp.backend.repositories;

import org.example.elearning_website_qmhp.backend.models.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICoursesRepository extends JpaRepository<Courses, Long> {

    @Query("SELECT c FROM Courses c JOIN FETCH c.user")
    Page<Courses> findAllCourses(Pageable pageable);

}
