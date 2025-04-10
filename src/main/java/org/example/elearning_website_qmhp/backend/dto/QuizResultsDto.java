package org.example.elearning_website_qmhp.backend.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultsDto {
    private Long resultId;
    private Long userId;
    private Long quizId;
    private double score;
    private LocalDateTime submittedAt;
}
