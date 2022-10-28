package com.example.university.repository.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "/teacher_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher_Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "s_id")
    private String s_id;

    @Column(name = "t_id")
    private String t_id;


    @ManyToOne
    @JoinColumn(name = "teacher_student_id")
    private Teacher_Student teacher_student;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "s_id")
    private Student student;

    @ManyToOne
    @JoinColumn(referencedColumnName = "t_id")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher_Student getTeacher_student() {
        return teacher_student;
    }

    public void setTeacher_student(Teacher_Student teacher_student) {
        this.teacher_student = teacher_student;
    }


    @Override
    public String toString() {
        return "teacher_student{" +
                "id ='" + id + '\'' +
                ", s_id ='" + s_id + '\'' +
                ", t_id ='" + t_id + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher_Student ts = (Teacher_Student) o;
        return id == ts.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, s_id, t_id);
    }
}
