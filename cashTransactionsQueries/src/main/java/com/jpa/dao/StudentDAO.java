package com.jpa.dao;

import com.jpa.model.Student;

import java.util.List;

public interface StudentDAO {

    Student addStudent(Student student);

    Student getStudent(int id);

    List<Student> findAllDynamicQuery();

    List<Student> findAllCriteriaApi();

    List<Student> findAllNativeQuery();

    List<Student> findAllNamedQuery();

}
