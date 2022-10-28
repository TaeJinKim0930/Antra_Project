package com.example.java20.week4.demo.university.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "teacher_student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher_Student> ts = new ArrayList<>();


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
