package com.example.java20.week4.restTemplate.service.impl;



import com.example.java20.week4.demo.university.domain.entity.Teacher_Student;
import com.example.java20.week4.demo.university.exception.ResourceNotFoundException;

import com.example.java20.week4.restTemplate.domain.CommonResponses;
import com.example.java20.week4.restTemplate.domain.entity.Employee;
import com.example.java20.week4.restTemplate.repository.EmployeeRepository;
import com.example.java20.week4.restTemplate.service.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestTemplateImpl implements RestTemplate {
    public String url = "https://dummy.restapiexample.com/api/v1/employees";
    private final EmployeeRepository er;

    @Autowired
    public RestTemplateImpl(EmployeeRepository er) {
        this.er = er;
    }

//    @Override
//    public CommonResponses findById(String id) {
//        // needs to be fixed
//        List<CommonResponses> employee = er.findById(id);
//        if(employee.isEmpty()) {
//            //log
//            throw new ResourceNotFoundException("...");
//        }
//        return new CommonResponses("Success",employee);
//    }
//
//    @Override
//    public CommonResponses findAll() {
//        // needs to be fixed
//        List<CommonResponses> employeeListList =  er.findAll();
//        return new CommonResponses("Success",employeeListList);
//    }
//
//    @Override
//    @Transactional
//    public CommonResponses insert(Employee stu) {
//        // needs to be fixed
//        Employee employee = er.insert(stu);
//        return new CommonResponses("Success",employee);
//    }

    @Autowired
    private org.springframework.web.client.RestTemplate restTemplate;

    @Override
    public CommonResponses findById(String id) {
        return null;
    }

    @Override
    public CommonResponses findAll() {
        return null;
    }

    @Override
    public CommonResponses insert(Employee employee) {
        return null;
    }

    @GetMapping("/{age}")
    public CommonResponses getEmployees() {
        CommonResponses response;
        response = restTemplate.getForObject(url, CommonResponses.class);
        return response;
    }

    @GetMapping("/id")
    public  CommonResponses getEmployeeUnderThirty() {
        CommonResponses response;
        response = restTemplate.getForObject(url, CommonResponses.class);
        // needs to be done more
        // Employee employee = new Employee();
        // employee.getEmployee_age() < 30
        return response;
    }



}