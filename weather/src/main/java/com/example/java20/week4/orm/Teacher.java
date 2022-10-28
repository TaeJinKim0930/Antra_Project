package com.example.java20.week4.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "/teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

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
    private List<Teacher_Student> StudentsForTea = new ArrayList<>();

    /**
     * construnction
     * used AllArgsConstructor
     *      - geneterates a constructor with one parameter for every field in the class
     *      - Link --> https://www.educative.io/answers/what-is-the-allargsconstructor-annotation-in-lombok
     * */

    /**
     * Getter Setter
     * */
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

    public List<Teacher_Student> getStudentSet() {
        return StudentsForTea;
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

    public void setStudentSet(List<Teacher_Student> studentList) {
        this.StudentsForTea = studentList;
    }


    public void addTeacher_students(Teacher_Student ts) {
        this.StudentsForTea.add(ts);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id ='" + id + '\'' +
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
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
