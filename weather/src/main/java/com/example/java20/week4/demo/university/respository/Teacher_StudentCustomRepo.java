package com.example.java20.week4.demo.university.respository;

import com.example.java20.week4.demo.university.domain.entity.Teacher_Student;
import org.springframework.stereotype.Repository;
public interface Teacher_StudentCustomRepo {
    Teacher_Student insert(Teacher_Student ts);
    Teacher_Student delete(String id);
    Teacher_Student update(String id, Teacher_Student ts);
}
