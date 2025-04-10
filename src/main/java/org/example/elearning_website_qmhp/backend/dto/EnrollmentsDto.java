package org.example.elearning_website_qmhp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentsDto {
    private Long enrollmentId;
    private Long userId;
    private Long courseId;
    private LocalDateTime enrolledAt;
}
