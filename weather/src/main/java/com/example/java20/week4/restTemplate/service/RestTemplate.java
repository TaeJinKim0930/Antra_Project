package com.example.java20.week4.restTemplate.service;





import com.example.java20.week4.restTemplate.domain.CommonResponses;
import com.example.java20.week4.restTemplate.domain.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestTemplate {
    CommonResponses findById(String id);
    CommonResponses findAll();
    CommonResponses insert(Employee employee);
    public CommonResponses getEmployees();

}
