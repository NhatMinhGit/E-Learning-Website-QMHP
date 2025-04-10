package org.example.elearning_website_qmhp.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
public class Quizzes {
    @Id
    @GeneratedValue
    @Column(name = "quiz_id")
    private Long quizId;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lessons lesson;

    @Column(name = "title", nullable = false,length = 255)
    private String title;

    @Column(name = "total_marks", nullable = false,length = 255)
    private Double totalMarks;
}
