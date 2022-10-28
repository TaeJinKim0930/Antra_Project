package com.example.university.repository.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "/student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String s_id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first")
    private  String first;

    @Column(name = "last")
    private  String last;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private List<Teacher_Student> teacher_student = new ArrayList<>();

    public Student(String s_id, int age, String first, String last) {
    }

    // was m - m
    @OneToMany
    private List<Teacher_Student> teacherForStu = new ArrayList<>();
    public List<Teacher_Student> getTeacherForStu() {
        return teacherForStu;
    }
    public String getId() {
        return s_id;
    }

    public void setId(UUID s_id) {
        this.s_id = String.valueOf(s_id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
                "id ='" + s_id + '\'' +
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
        return s_id == student.s_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s_id);
    }
}
