package com.jpa.worker;

import com.jpa.dao.LectureDAO;
import com.jpa.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("lectureWorker")
@Transactional
public class LecturesWorker {

    @Autowired
    LectureDAO lecturesDao;

    public Lecture addLecture(Lecture lecture) {
        lecture = lecturesDao.addLecture(lecture);
        return lecture;
    }

    public Lecture getLecture(Integer id) {
        return lecturesDao.getLecture(id);
    }

    public void updateLecture(Lecture lecture) {
        lecturesDao.saveLecture(lecture);
    }

}
