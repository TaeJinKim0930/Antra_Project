package com.example.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_StudentRepo extends JpaRepository<Teacher_StudentRepo, String> {

}
