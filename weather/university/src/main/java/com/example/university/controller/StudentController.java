package com.example.university.controller;


import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.service.StudentService;
import com.sun.istack.logging.Logger;
import org.hibernate.internal.IteratorImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/university")
public class StudentController {

    static Logger Logger = (com.sun.istack.logging.Logger) LoggerFactory.getLogger((StudentController.class));
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, Student student) {
        this.studentService = studentService;
    }

    // save teacher into json
    @GetMapping(value = "/student", headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<CommonResponses> saveAllStudent(@RequestBody Student student) {
        Logger.info("save student");
        student.setId(UUID.randomUUID());
        CommonResponses newStudent = studentService.insert(student);
        Logger.info("Student saved");
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    // get all saved info
    @GetMapping(value = "/student", headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<CommonResponses> getAllStudent(@RequestBody Student student) {
        Logger.info("get all students");
        Iterable<Student> students = (Iterable<Student>) studentService.findAll();
        if(students == null) {
            Logger.info("404 error: No student found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Logger.info("all student retrieved");
            //List<Student> studentList = // IteratorUtils.toLust(student.iterator());
            return new ResponseEntity<>(HttpStatus.FOUND);
        }


    }

    // receiving gateway configuration
    @GetMapping("/student") // http://localhost:5432/university/student
    public ResponseEntity<String> get() {
        return new ResponseEntity<String>("Student Info: ", HttpStatus.OK);
    }

    @GetMapping("/{s_id}")
    public ResponseEntity<CommonResponses> findStuById(@PathVariable String s_id) {
        return new ResponseEntity<>(studentService.findById(s_id), HttpStatus.OK);
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
    @DeleteMapping("/{s_id}")
    public void delete(@PathVariable String s_id) {
        studentService.delete(s_id);
        System.out.println(HttpStatus.ACCEPTED);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponses> handleNotFound() {
        return new ResponseEntity<>(
                new CommonResponses(-1, new Date(), 'b'),
                HttpStatus.NOT_FOUND
        );
    }
}