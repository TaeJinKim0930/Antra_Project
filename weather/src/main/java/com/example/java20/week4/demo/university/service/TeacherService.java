package com.example.java20.week4.demo.university.service;

import com.example.java20.week4.demo.university.domain.CommonResponse;
import com.example.java20.week4.demo.university.domain.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Teacher tea);

    CommonResponse delete(String id);
    CommonResponse update(String id, Teacher teacher);
}
