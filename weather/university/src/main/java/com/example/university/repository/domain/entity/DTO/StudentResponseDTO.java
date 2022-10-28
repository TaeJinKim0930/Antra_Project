package com.example.university.repository.domain.entity.DTO;

import com.example.university.repository.domain.entity.DTO.StudentDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {
    @JsonProperty("student data")
    private List<StudentDTO> student;
}
