package com.example.university.controller;


import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, Student student) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponses> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CommonResponses> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponses> insert(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.CREATED);
    }
    // Updating
    public ResponseEntity<CommonResponses> update(@RequestBody Student student, @PathVariable String id) {
        return new ResponseEntity<>(studentService.update(id, student), HttpStatus.OK);
    }

    // Deleting
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
        System.out.println(HttpStatus.ACCEPTED);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponses> handleNotFound() {
        return new ResponseEntity<>(
                new CommonResponses(-1, new Date(), "resource not found"),
                HttpStatus.NOT_FOUND
        );
    }
}