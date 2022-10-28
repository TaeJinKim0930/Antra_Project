package com.example.repository.employee.service;

import com.example.repository.employee.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDTO> fetchEmpAgeLargerThan(int age);
}
