package com.example.university.repository;

import com.example.university.repository.domain.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCustomRepo {
    Student insert(Student student);
    Student delete(String id);
    Student update(String id, Student student);
}
