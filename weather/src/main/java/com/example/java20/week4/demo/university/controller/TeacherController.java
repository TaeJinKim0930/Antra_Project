package com.example.java20.week4.demo.university.controller;

import com.example.java20.week4.demo.university.domain.CommonResponse;
import com.example.java20.week4.demo.university.domain.entity.Teacher;
import com.example.java20.week4.demo.university.exception.ResourceNotFoundException;
import com.example.java20.week4.demo.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }
    // Reading
    @GetMapping()
    public ResponseEntity<CommonResponse> findAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    // Creating
    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.insert(teacher), HttpStatus.CREATED);
    }

    // Updating
    public ResponseEntity<CommonResponse> update(@RequestBody Teacher teacher, @PathVariable String id) {
        return new ResponseEntity<>(teacherService.update(id, teacher), HttpStatus.OK);
    }

    // Deleting
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        teacherService.delete(id);
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
