package com.example.java20.week4.demo.university.controller;

import com.example.java20.week4.demo.university.domain.CommonResponse;
import com.example.java20.week4.demo.university.domain.entity.Student;
import com.example.java20.week4.demo.university.exception.ResourceNotFoundException;
import com.example.java20.week4.demo.university.service.StudentService;
import com.example.java20.week4.demo.university.service.StudentService;
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
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CommonResponse> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.CREATED);
    }
    // Updating
    public ResponseEntity<CommonResponse> update(@RequestBody Student student, @PathVariable String id) {
        return new ResponseEntity<>(studentService.update(id, student), HttpStatus.OK);
    }

    // Deleting
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
        System.out.println(HttpStatus.ACCEPTED);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponse> handleNotFound() {
        return new ResponseEntity<>(
                new CommonResponse(-1, new Date(), "resource not found"),
                HttpStatus.NOT_FOUND
        );
    }
}
