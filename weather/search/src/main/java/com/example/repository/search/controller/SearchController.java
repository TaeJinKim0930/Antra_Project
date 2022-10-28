package com.example.repository.search.controller;

import com.example.repository.search.exception.ConnectionNotFoundException;
import com.example.repository.search.service.EmployeeService;
import com.example.repository.search.service.UniversityService;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    private final EmployeeService employeeService;
    private final UniversityService universityService;

    public SearchController(EmployeeService employeeService, UniversityService universityService) {
        this.employeeService = employeeService;
        this.universityService = universityService;
    }

    @GetMapping("/university")
    public String getUni(@RequestParam List<Integer> ages) throws RestClientException {

        //TODO
        String url = "https:///localhost:5432/university";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(
                    url, HttpMethod.GET, getHeaders(), String.class
            );
        } catch (Exception ex) {
            // connection failed
            System.out.println(ex);
            throw new ConnectionNotFoundException(ex);
        }
        System.out.println(response.getBody());
        return response.getBody().toString();
    }

    @GetMapping("/search/employees")
    @Hystrix(fallbackHandler = "getAllEmployee", cacheKey = "getAllEmployee")
    public String getEmp(@RequestParam List<Integer> ages) throws RestClientException {

        //TODO
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(
                    url, HttpMethod.GET, getHeaders(), String.class
            );
        } catch (Exception ex) {
            // connection failed
            System.out.println(ex);
            throw new ConnectionNotFoundException(ex);
        }
        System.out.println(response.getBody());
        return response.getBody().toString();
    }

    public ResponseEntity<?> getAllEmployee(List<Integer> ages) {
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }

    private static HttpEntity<?> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }


}
