package com.zp.dao;


import com.zp.entity.Student;
import com.zp.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoInterface {

    Student findStudentByStudentId(String studentId);
    Teacher findTeacherById(String teacherId);

    void addStudent(Student studnet);
}
