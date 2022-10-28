package com.example.university.repository.Impl;


import com.example.university.repository.domain.entity.Student;
import com.example.university.repository.domain.entity.Teacher;
import com.example.university.repository.StudentCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentRepoImpl implements StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepoImpl(EntityManager entityManager) {
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
        return student;
    }
}
