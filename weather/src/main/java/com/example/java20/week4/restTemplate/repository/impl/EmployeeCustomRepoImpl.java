package com.example.java20.week4.restTemplate.repository.impl;

import com.example.java20.week4.restTemplate.domain.entity.Employee;
import com.example.java20.week4.restTemplate.repository.EmployeeCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeCustomRepoImpl implements EmployeeCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee insert(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }
}
