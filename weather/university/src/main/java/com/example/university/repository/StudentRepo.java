package com.example.university.repository;

import com.example.university.repository.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentRepo, String> {

    Student insert(Student stu);
}
