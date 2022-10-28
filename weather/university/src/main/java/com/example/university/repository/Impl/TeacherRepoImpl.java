package com.example.university.repository.Impl;


import com.example.university.repository.domain.entity.Student;
import com.example.university.repository.domain.entity.Teacher;
import com.example.university.repository.TeacherCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TeacherRepoImpl implements TeacherCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public TeacherRepoImpl(EntityManager entityManager) {
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
        entityManager.find(Student.class, teacher.getId());
        entityManager.merge(teacher);

        return teacher;
    }
}
