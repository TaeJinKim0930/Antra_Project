package com.example.gateway.service.Impl;

import com.example.gateway.domain.CommonResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Service
public class RestTemplateImpl extends RestTemplate {
    public String url = "jdbc:postgresql://localhost:5432/university";


    // Employee and EmployeeRepo needs to be changed after setting up the entity of gateway to save
    // university data.
    // will be handled after figuring out entity
//    private final EmployeeRepository er;
//
//    @Autowired
//    public RestTemplateImpl(EmployeeRepository er) {
//        this.er = er;
//    }
//
//    @Autowired
//    private org.springframework.web.client.RestTemplate restTemplate;
//
//    @Override
//    public CommonResponses findById(String id) {
//        return null;
//    }
//
//    @Override
//    public CommonResponses findAll() {
//        return null;
//    }
//
//    @Override
//    public CommonResponses insert(Employee employee) {
//        return null;
//    }
//
//    @GetMapping("/{age}")
//    public CommonResponses getEmployees() {
//        CommonResponses response;
//        response = restTemplate.getForObject(url, CommonResponses.class);
//        return response;
//    }

//    @GetMapping("/id")
//    public  CommonResponses getEmployeeUnderThirty() {
//        CommonResponses response;
//        response = restTemplate.getForObject(url, CommonResponses.class);
//        // needs to be done more
//        // Employee employee = new Employee();
//        // employee.getEmployee_age() < 30
//        return response;
//    }



}