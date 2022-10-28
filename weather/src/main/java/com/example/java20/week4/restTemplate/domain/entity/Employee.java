package com.example.java20.week4.restTemplate.domain.entity;

import com.example.java20.week4.demo.university.domain.entity.Teacher_Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "/employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "employee_name")
    private String employee_name;

    @Column(name = "employee_salary")
    private int employee_salary;

    @Column(name = "employee_age")
    private int employee_age;

    @Column(name = "profile_image")
    private String profile_image;

    @Override
    public String toString() {
        return "teacher_student{" +
                "employee_name ='" + employee_name + '\'' +
                ", employee_age ='" + employee_age + '\'' +
                ", profile_image ='" + profile_image + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return id == e.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee_name, employee_age, profile_image);
    }
}
