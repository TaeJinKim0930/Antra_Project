package com.example.university.service.impl;


import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.repository.StudentRepo;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public CommonResponses findById(String id) {
        Optional<StudentRepo> stu =  studentRepo.findById(id);
        if(stu.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponses(0, new Date(), stu.get());
    }

    @Override
    public CommonResponses findAll() {
        List<StudentRepo> stuList =  studentRepo.findAll();
        return new CommonResponses(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponses insert(Student stu) {
        Student student = this.studentRepo.insert(stu);
        return new CommonResponses(0, new Date(), student.getId());
    }

    @Override
    public CommonResponses update(String id, Student student) {
        return null;
    }

    @Override
    public CommonResponses delete(String id) {
        Optional<StudentRepo> s_id = studentRepo.findById(id);
        if(s_id.isEmpty()) {
            throw new ResourceNotFoundException("...");
        }
        studentRepo.delete((s_id.get()));
        return new CommonResponses(0, new Date(), s_id.get());
    }
}
