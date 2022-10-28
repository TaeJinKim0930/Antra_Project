package com.example.repository.employee.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponseDTO {
    @JsonProperty("data")
    private List<EmployeeDTO> employees;
}
