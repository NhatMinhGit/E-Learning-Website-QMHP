package org.example.elearning_website_qmhp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEditDto {
    private Long courseId;
    private String title;
    private String description;
}
