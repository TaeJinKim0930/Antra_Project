package com.example.java20.week4.restTemplate.controller;


import com.example.java20.week4.restTemplate.domain.CommonResponses;
import com.example.java20.week4.restTemplate.service.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/id")
public class RestController {

    @Autowired
    RestTemplate restTemplate;

    // https://dummy.restapiexample.com/api/v1/employees
    @RequestMapping(
            value = "/id",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CommonResponses getAllEmployeeList() {
        CommonResponses postResponse;
        postResponse = restTemplate.getEmployees();
        return postResponse;
    }

    public void getOverThirtyEmployee() {}
}
