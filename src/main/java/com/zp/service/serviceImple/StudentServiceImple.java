package com.zp.service.serviceImple;

import com.zp.dao.StudentDaoInterface;
import com.zp.entity.Student;
import com.zp.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImple implements StudentServiceInterface {

    @Autowired
    StudentDaoInterface studentDaoInterface;

    @Override
    public List<Student> findAllStudent() {
        return studentDaoInterface.findAllStudent();
    }

    @Override
    public List<String> findAllStudentId() {
        return studentDaoInterface.findAllStudentId();
    }

    @Override
    public void updateStudent(Student student) {
        studentDaoInterface.updateStudent(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        studentDaoInterface.deleteStudent(studentId);
    }

    @Override
    public void updateScore(Integer score, String studentName) {
        studentDaoInterface.updateScore(score,studentName);
    }

    @Override
    public int selectMaxScore() {

        return studentDaoInterface.selectMaxScore();
    }

    @Override
    public int selectMinScore() {
        return studentDaoInterface.selectMinScore();
    }

    @Override
    public int countStudent() {
        return studentDaoInterface.countStudent();
    }

    @Override
    public int sumScore() {
        return studentDaoInterface.sumScore();
    }
}
