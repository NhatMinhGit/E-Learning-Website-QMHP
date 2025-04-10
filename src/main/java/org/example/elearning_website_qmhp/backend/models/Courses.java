package org.example.elearning_website_qmhp.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title",nullable = false, length = 255)
    private String title;

    @Column(name = "description", nullable = true, length = 510)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "create_at", nullable = false,updatable = false)
    private LocalDateTime createAt;
}
