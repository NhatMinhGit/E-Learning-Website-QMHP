package org.example.elearning_website_qmhp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto {
    private Long courseId;
    private String title;
    private String description;
//    private Long userId;
    private int enrollmentCount;
    private LocalDateTime createAt;
}
