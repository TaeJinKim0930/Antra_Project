package com.example.university.repository.domain.entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Teacher_StudentResponseDTO {
    @JsonProperty("TS data")
    private List<Teacher_StudentDTO> ts;
}
