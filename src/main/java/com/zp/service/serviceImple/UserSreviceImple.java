package com.zp.service.serviceImple;

import com.zp.dao.UserDaoInterface;
import com.zp.entity.Student;
import com.zp.entity.Teacher;
import com.zp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSreviceImple implements UserServiceInterface {
    @Autowired
    UserDaoInterface userDaoInterface;

    @Override
    public void addStudent(Student student) {
        userDaoInterface.addStudent(student);
    }



    @Override
    public Student findStudentByStudentId(String studentId) {
        return userDaoInterface.findStudentByStudentId(studentId);
    }

    @Override
    public Teacher findTeacherById(String teacherId) {
        return userDaoInterface.findTeacherById(teacherId);    }
}
