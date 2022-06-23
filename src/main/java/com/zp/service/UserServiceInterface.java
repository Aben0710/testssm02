package com.zp.service;

import com.zp.entity.Student;
import com.zp.entity.Teacher;


public interface UserServiceInterface {

    Student findStudentByStudentId(String studentId);

    Teacher findTeacherById(String teacherId);

    void addStudent(Student studnet);

}
