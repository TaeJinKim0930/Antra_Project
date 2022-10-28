package com.example.university.controller;

import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Student;
import com.example.university.repository.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/university")
public class TeacherController {

    static org.slf4j.Logger Logger = LoggerFactory.getLogger(TeacherController.class);

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // save teacher into json
    @GetMapping(value = "/teacher", headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<CommonResponses> saveAllTeacher(@RequestBody Teacher teacher) {
        Logger.info("save teacher");
        teacher.setId(UUID.randomUUID());
        CommonResponses newTeacher = teacherService.insert(teacher);
        Logger.info("Teacher saved");
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    // get all saved info
    @GetMapping(value = "/teacher", headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<CommonResponses> getAllStudent(@RequestBody Teacher teacher) {
        Logger.info("get all teacher");
        Iterable<Teacher> teachers = (Iterable<Teacher>) teacherService.findAll();
        if(teachers == null) {
            Logger.info("404 error: No teacher found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Logger.info("all teacher retrieved");
            // this part needs to be done..
            // List<Teacher> teacherList = //IteratorUtils.toLust(teacher.iterator());
            return new ResponseEntity<>(HttpStatus.FOUND);
        }


    }


    // receiving gateway configuration
    @GetMapping("/teacher") // http://localhost:5432/university/teacher
    public ResponseEntity<String> get() {
        return new ResponseEntity<String>("Teacher Info: ", HttpStatus.OK);
    }


    @GetMapping("/{t_id}")
    public ResponseEntity<CommonResponses> findStuById(@PathVariable String t_id) {
        return new ResponseEntity<>(teacherService.findById(t_id), HttpStatus.OK);
    }
    // Reading
    @GetMapping()
    public ResponseEntity<CommonResponses> findAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    // Creating
    @PostMapping
    public ResponseEntity<CommonResponses> insert(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.insert(teacher), HttpStatus.CREATED);
    }

    // Updating
    public ResponseEntity<CommonResponses> update(@RequestBody Teacher teacher, @PathVariable String t_id) {
        return new ResponseEntity<>(teacherService.update(t_id, teacher), HttpStatus.OK);
    }

    // Deleting
    @DeleteMapping("/{t_id}")
    public void delete(@PathVariable String id) {
        teacherService.delete(id);
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