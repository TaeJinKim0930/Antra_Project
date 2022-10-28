package com.example.university.repository;

import com.example.university.repository.domain.entity.Teacher;

public interface TeacherCustomRepo {
    Teacher insert(Teacher teacher);
    Teacher delete(String id);
    Teacher update(String id, Teacher teacher);
}
