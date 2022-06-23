package com.zp.service;

import com.zp.entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    List<Student> findAllStudent();
    List<String>findAllStudentId();
    void updateStudent(Student student);
    void deleteStudent(String studentId);
    void updateScore(Integer score,String studentName);
    int selectMaxScore();
    int selectMinScore();
    int countStudent();
    int sumScore();
}
