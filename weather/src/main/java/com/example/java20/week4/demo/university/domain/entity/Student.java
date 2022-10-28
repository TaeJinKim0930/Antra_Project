package com.example.java20.week4.demo.university.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "/student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "age")
    private String age;

    @Column(name = "first")
    private  String first;

    @Column(name = "last")
    private  String last;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher_Student> teacher_student = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public List<Teacher_Student> getTeacher_student() {
        return teacher_student;
    }

    public void setTeacher_student(List<Teacher_Student> teacher_student) {
        this.teacher_student = teacher_student;
    }

    public void addTeacher_Student(Teacher_Student ts) {
        this.teacher_student.add(ts);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id ='" + id + '\'' +
                ", name ='" + age + '\'' +
                ", first ='" + first + '\'' +
                ", last ='" + last + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
