package com.example.repository.employee.service;

import com.example.repository.employee.domain.EmployeeDTO;
import com.example.repository.employee.domain.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final RestTemplate restTemplate;

    @Value("${employee-endpoint}")
    private String url;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<EmployeeDTO> fetchEmpAgeLargerThan(int age) {
        EmployeeResponseDTO employeeResponseDTO = restTemplate.getForObject(url, EmployeeResponseDTO.class);
        return employeeResponseDTO.getEmployees()
                    .stream()
                    .filter(e -> e.getEmployee_age() >= age)
                    .collect(Collectors.toList());
    }
}
