package com.jpa.dao.impl;

import com.jpa.dao.LectureDAO;
import com.jpa.model.Lecture;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class LectureDAOImpl implements LectureDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Lecture addLecture(Lecture lecture) {
        entityManager.persist(lecture);
        return lecture;
    }

    @Override
    public Lecture getLecture(int id) {
        return entityManager.find(Lecture.class, id);
    }

    @Override
    public void saveLecture(Lecture lecture) {
        entityManager.merge(lecture);
    }
}
