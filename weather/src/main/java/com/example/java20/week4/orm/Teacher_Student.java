package com.example.java20.week4.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TeacherAndStudent",
            joinColumns = @JoinColumn(name = "/Student"),
            inverseJoinColumns = @JoinColumn(name = "/Teacher")
    )
    private List<Teacher_Student> ts = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public List<Teacher_Student> getTs() {
        return ts;
    }

    public void setTs(List<Teacher_Student> ts) {
        this.ts = ts;
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
        Teacher_Student that = (Teacher_Student) o;
        return Objects.equals(id, that.id) && Objects.equals(s_id, that.s_id) && Objects.equals(t_id, that.t_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, s_id, t_id);
    }
}
