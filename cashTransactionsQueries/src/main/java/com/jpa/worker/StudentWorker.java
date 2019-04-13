package com.jpa.worker;

import com.jpa.dao.StudentDAO;
import com.jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentWorker")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class StudentWorker {


    @Autowired
    StudentDAO studentDAO;

    public Student addStudent(Student student) {
        student = studentDAO.addStudent(student);
        return student;
    }

    public Student getStudent(Integer id) {
        return studentDAO.getStudent(id);
    }

    public List<Student> findAllDynamicQuery() {
        return studentDAO.findAllDynamicQuery();
    }

    public List<Student> findAllCriteriaApi() {
        return studentDAO.findAllCriteriaApi();
    }

    public List<Student> findAllNativeQuery() {
        return studentDAO.findAllNativeQuery();
    }

    public List<Student> findAllNamedQuery() {
        return studentDAO.findAllNamedQuery();
    }

}
