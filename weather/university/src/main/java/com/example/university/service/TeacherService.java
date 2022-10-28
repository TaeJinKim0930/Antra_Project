package com.example.university.service;

import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    CommonResponses findById(String id);
    CommonResponses findAll();

    CommonResponses insert(Teacher tea);
    CommonResponses update(String id, Teacher teacher);
    CommonResponses delete(String id);

}
