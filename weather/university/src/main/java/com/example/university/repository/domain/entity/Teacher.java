package com.example.university.repository.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "/teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String t_id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Teacher_Student> TeacherForStu = new ArrayList<>();

    // was m-m
    @OneToMany
    private List<Teacher_Student> StudentsForTea = new ArrayList<>();
    public String getId() {
        return t_id;
    }

    public void setId(UUID t_id) {
        this.t_id = String.valueOf(t_id);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public List<Teacher_Student> getTeacherForStu() {
        return TeacherForStu;
    }

    public void setTeacherForStu(List<Teacher_Student> teacherForStu) {
        TeacherForStu = teacherForStu;
    }

    public void addTeacher_students(Teacher_Student ts) {
        this.TeacherForStu.add(ts);
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id ='" + t_id + '\'' +
                ", age ='" + age + '\'' +
                ", first ='" + first + '\'' +
                ", last ='" + last + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return t_id == teacher.t_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_id);
    }
}
