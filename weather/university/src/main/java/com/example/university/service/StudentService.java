package com.example.university.service;

import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    CommonResponses findById(String id);
    CommonResponses findAll();
    CommonResponses insert(Student stu);

    CommonResponses update(String id, Student student);
    CommonResponses delete(String id);
}
