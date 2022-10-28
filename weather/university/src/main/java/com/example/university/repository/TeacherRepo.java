package com.example.university.repository;

import com.example.university.repository.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherRepo, String> {

    Teacher insert(Teacher tea);
}
