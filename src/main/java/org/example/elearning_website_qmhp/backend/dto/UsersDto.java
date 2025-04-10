package org.example.elearning_website_qmhp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean status;
    private LocalDateTime createAt;
}
