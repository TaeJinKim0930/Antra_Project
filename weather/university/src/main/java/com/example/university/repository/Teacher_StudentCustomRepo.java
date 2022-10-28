package com.example.university.repository;

import com.example.university.repository.domain.entity.Teacher_Student;

public interface Teacher_StudentCustomRepo {
    Teacher_Student insert(Teacher_Student ts);
    Teacher_Student delete(String id);
    Teacher_Student update(String id, Teacher_Student ts);
}
