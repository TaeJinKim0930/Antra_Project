package com.example.university.service.impl;

import com.example.university.repository.domain.CommonResponses;
import com.example.university.repository.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.repository.TeacherRepo;
import com.example.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public CommonResponses findById(String id) {
        Optional<TeacherRepo> tea =  teacherRepo.findById(id);
        if(tea.isEmpty()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponses(0, new Date(), tea.get());
    }

    @Override
    public CommonResponses findAll() {
        List<TeacherRepo> teaList =  teacherRepo.findAll();
        return new CommonResponses(0, new Date(), teaList);
    }

    @Override
    @Transactional
    public CommonResponses insert(Teacher tea) {
        Teacher teacher = this.teacherRepo.insert(tea);
        return new CommonResponses(0, new Date(), teacher.getId());
    }

    @Override
    public CommonResponses delete(String id) {
        Optional<TeacherRepo> t_id = teacherRepo.findById(id);
        if(t_id.isEmpty()) {
            throw new ResourceNotFoundException("...");
        }
        teacherRepo.delete((TeacherRepo) t_id.get());
        return new CommonResponses(0, new Date(), t_id.get());
    }

    @Override
    public CommonResponses update(String id, Teacher teacher) {
        return null;
    }
}
