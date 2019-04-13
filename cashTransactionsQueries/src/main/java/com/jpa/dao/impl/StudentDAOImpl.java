package com.jpa.dao.impl;

import com.jpa.dao.StudentDAO;
import com.jpa.model.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student addStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Cacheable(cacheNames = "studentCache")
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllDynamicQuery() {

        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findAllCriteriaApi() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);

        Root<Student> s = criteriaQuery.from(Student.class);
        criteriaQuery.select(s);

        Query query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public List<Student> findAllNativeQuery() {
        Query query = entityManager.createNativeQuery("SELECT * from students", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findAllNamedQuery() {
        Query query = entityManager.createNamedQuery(Student.FIND_ALL_BY_NAMED_QUERY);

        return query.getResultList();
    }
}
