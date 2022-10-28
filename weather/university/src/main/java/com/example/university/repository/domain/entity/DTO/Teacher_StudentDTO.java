package com.example.university.repository.domain.entity.DTO;

import lombok.Data;

/**
 * id: 1,
 * s_id : 2,
 * t_id : 3
 *
 */

@Data
public class Teacher_StudentDTO {
    private String id;
    private String s_id;
    private String t_id;
}
