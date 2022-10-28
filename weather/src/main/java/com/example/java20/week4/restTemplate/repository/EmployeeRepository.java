package com.example.java20.week4.restTemplate.repository;



import com.example.java20.week4.restTemplate.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, EmployeeCustomRepo { }
