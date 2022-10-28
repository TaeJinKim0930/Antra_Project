package com.example.gateway.service;

import com.example.gateway.domain.CommonResponses;
import org.springframework.stereotype.Service;

@Service
public interface RestTemplate {
    CommonResponses findById(String id);
    CommonResponses findAll();
    // CommonResponses insert(Employee employee);
    public CommonResponses getEmployees();

}
