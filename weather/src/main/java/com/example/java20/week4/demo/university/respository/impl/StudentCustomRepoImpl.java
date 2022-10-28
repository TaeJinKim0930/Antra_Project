package com.example.java20.week4.demo.university.respository.impl;

import com.example.java20.week4.demo.university.domain.entity.Student;
import com.example.java20.week4.demo.university.domain.entity.Teacher;
import com.example.java20.week4.demo.university.domain.entity.Teacher_Student;
import com.example.java20.week4.demo.university.respository.StudentCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentCustomRepoImpl implements StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public StudentCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student insert(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student delete(String id) {
        Student stu = new Student();
        entityManager.persist((stu));
        return stu;
    }

    @Override
    public Student update(String id, Student student) {
        // need to be done more.
        entityManager.find(Teacher.class, student.getId());
        entityManager.merge(student);
        return null;
    }

}
