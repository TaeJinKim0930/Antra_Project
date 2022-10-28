package com.example.java20.week4.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "/student")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @ManyToMany
    private List<Teacher_Student> teacherForStu = new ArrayList<>();

    public Student(String id, Integer age, String first, String last) {
        this.id = id;
        this.age = age;
        this.first = first;
        this.last = last;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public List<Teacher_Student> getTeacherForStu() {
        return teacherForStu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setTeacherForStu(List<Teacher_Student> teacherForStu) {
        this.teacherForStu = teacherForStu;
    }


    public void addTeacher_student(Teacher_Student ts) {
        this.teacherForStu.add(ts);
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
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/**
 *   A 1 - m B
 */

