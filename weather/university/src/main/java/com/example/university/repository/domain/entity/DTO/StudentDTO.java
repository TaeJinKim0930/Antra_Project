package com.example.university.repository.domain.entity.DTO;


import lombok.Data;

/**
 * id: 1,
 * age : 11,
 * first : tj,
 * last : k
 *
 *
 */


@Data
public class StudentDTO {
    private String id;
    private int age;
    private String first;
    private String last;
}
