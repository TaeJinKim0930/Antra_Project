package com.example.university.repository.domain.entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TeacherResponseDTO {
    @JsonProperty("Teacher data")
    private List<TeacherDTO> teacher;
}
