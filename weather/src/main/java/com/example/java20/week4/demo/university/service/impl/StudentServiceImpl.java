package com.example.java20.week4.demo.university.service.impl;

import com.example.java20.week4.demo.university.controller.StudentController;
import com.example.java20.week4.demo.university.domain.CommonResponse;
import com.example.java20.week4.demo.university.domain.entity.Student;
import com.example.java20.week4.demo.university.exception.ResourceNotFoundException;
import com.example.java20.week4.demo.university.respository.StudentCustomRepo;
import com.example.java20.week4.demo.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final com.example.java20.week4.demo.university.respository.Student student;

    @Autowired
    public StudentServiceImpl(com.example.java20.week4.demo.university.respository.Student student) {
        this.student = student;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<com.example.java20.week4.demo.university.respository.Student> stu =  student.findById(id);
        if(stu.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponse(0, new Date(), stu.get());
    }

    @Override
    public CommonResponse findAll() {
        List<com.example.java20.week4.demo.university.respository.Student> stuList =  student.findAll();
        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Student stu) {
        Student student = (Student) this.student.insert((com.example.java20.week4.demo.university.respository.Student) stu);
        return new CommonResponse(0, new Date(), student.getId());
    }

    @Override
    public CommonResponse update(String id, Student student) {
        return null;
    }

    @Override
    public CommonResponse delete(String id) {
        Optional<com.example.java20.week4.demo.university.respository.Student> s_id = student.findById(id);
        if(s_id.isEmpty()) {
            throw new ResourceNotFoundException("...");
        }
        student.delete((s_id.get()));
        return new CommonResponse(0, new Date(), s_id.get());
    }
}
