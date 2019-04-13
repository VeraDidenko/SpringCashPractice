package com.jpa.model;

import javax.persistence.*;

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "students")
@Cacheable
@NamedQueries({
        @NamedQuery(name = Student.FIND_ALL_BY_NAMED_QUERY, query = "SELECT s from Student s")
})
public class Student {

    public static final String FIND_ALL_BY_NAMED_QUERY = "Student.findAllByNamedQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studentId;


    @Column(name = "pib", nullable = false, columnDefinition = "varchar(100)")
    private String pib;

    @Column(name = "course")
    private Integer course;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", pib='" + pib +
                "}";
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }
}
