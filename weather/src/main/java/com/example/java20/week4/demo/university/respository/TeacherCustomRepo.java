package com.example.java20.week4.demo.university.respository;

import com.example.java20.week4.demo.university.domain.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCustomRepo {
    Teacher insert(Teacher teacher);
    Teacher delete(String id);
    Teacher update(String id, Teacher teacher);
}
