package org.example.elearning_website_qmhp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizzesDto {
    private Long quizId;
    private Long lessonId;
    private String title;
    private Double totalMarks;
}
