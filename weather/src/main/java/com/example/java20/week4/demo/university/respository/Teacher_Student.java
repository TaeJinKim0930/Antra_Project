package com.example.java20.week4.demo.university.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_Student extends JpaRepository<Teacher_Student, String>, Teacher_StudentCustomRepo {

}
