package com.jpa.dao;

import com.jpa.model.Lecture;

public interface LectureDAO {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);

    void saveLecture(Lecture lecture);

}
