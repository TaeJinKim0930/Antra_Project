package com.example.gateway.controller;

import com.example.gateway.domain.CommonResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/university")
public class gatewayController {

    @Autowired
    gatewayController gatewayController;

    // jdbc:postgresql://localhost:5432/university
//    @RequestMapping(
//            value = "/id",
//            method = RequestMethod.GET,
//            consumes = MediaType.ALL_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public CommonResponses getAllEmployeeList() {
//        CommonResponses postResponse;
//        // postResponse = will be setted later.getEmployees();
//        return postResponse;
//    }

}
