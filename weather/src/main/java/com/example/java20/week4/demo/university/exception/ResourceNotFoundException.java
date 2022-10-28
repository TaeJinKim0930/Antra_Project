package com.example.java20.week4.demo.university.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super();
    }
}

