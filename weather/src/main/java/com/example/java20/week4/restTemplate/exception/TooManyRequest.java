package com.example.java20.week4.restTemplate.exception;

import com.example.java20.week4.restTemplate.service.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;


public class TooMnyRequest extends RuntimeException {
    private HttpStatus httpStatus;
    public TooManyRequest (String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        try {
            String url = "https://dummy.restapiexample.com/api/v1/employees";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        }catch (HttpStatusCodeException ex) {
            // 404
            System.out.println(ex.getRawStatusCode());
            System.out.println();
        }

        return httpStatus;
    }


}
