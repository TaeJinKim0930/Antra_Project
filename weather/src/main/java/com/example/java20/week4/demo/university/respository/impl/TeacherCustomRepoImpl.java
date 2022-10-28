package com.example.java20.week4.demo.university.respository.impl;

import com.example.java20.week4.demo.university.domain.entity.Teacher;
import com.example.java20.week4.demo.university.domain.entity.Teacher_Student;
import com.example.java20.week4.demo.university.respository.TeacherCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TeacherCustomRepoImpl implements TeacherCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public TeacherCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher insert(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher delete(String id) {
        Teacher tea = new Teacher();
        entityManager.persist(tea);
        return tea;
    }

    @Override
    public Teacher update(String id, Teacher teacher) {
        // need to be done more.
        entityManager.find(Teacher.class, teacher.getId());
        entityManager.merge(teacher);

        return null;
    }
}
