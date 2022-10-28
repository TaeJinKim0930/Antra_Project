package com.example.java20.week4.demo.university.service.impl;

import com.example.java20.week4.demo.university.domain.CommonResponse;
import com.example.java20.week4.demo.university.domain.entity.Student;
import com.example.java20.week4.demo.university.domain.entity.Teacher;
import com.example.java20.week4.demo.university.exception.ResourceNotFoundException;
import com.example.java20.week4.demo.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final com.example.java20.week4.demo.university.respository.Teacher teacher;

    @Autowired
    public TeacherServiceImpl(Teacher teacher) {
        this.teacher = (com.example.java20.week4.demo.university.respository.Teacher) teacher;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<com.example.java20.week4.demo.university.respository.Teacher> tea =  teacher.findById(id);
        if(tea.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponse(0, new Date(), tea.get());
    }

    @Override
    public CommonResponse findAll() {
        List<com.example.java20.week4.demo.university.respository.Teacher> teaList =  teacher.findAll();
        return new CommonResponse(0, new Date(), teaList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Teacher tea) {
        Teacher teacher = this.teacher.insert(tea);
        return new CommonResponse(0, new Date(), teacher.getId());
    }

    @Override
    public CommonResponse delete(String id) {
        Optional<com.example.java20.week4.demo.university.respository.Teacher> t_id = teacher.findById(id);
        if(t_id.isEmpty()) {
            throw new ResourceNotFoundException("...");
        }
        teacher.delete((com.example.java20.week4.demo.university.respository.Teacher) t_id.get());
        return new CommonResponse(0, new Date(), t_id.get());
    }

    @Override
    public CommonResponse update(String id, Teacher teacher) {
        return null;
    }
}
