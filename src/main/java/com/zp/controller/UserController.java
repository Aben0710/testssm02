package com.zp.controller;

import com.zp.entity.Student;
import com.zp.entity.Teacher;
import com.zp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request,String userId, String password, String role) {

        if (role.equals("student")) {//学生登录
            Student student = userServiceInterface.findStudentByStudentId(userId);
            if (student == null || !(student.getPassword().equals(password))) {
                return "loginError";
            }
            // 把用戶的信息存入session中
            request.getSession().setAttribute("student",student);
            return "redirect:studentIndex.jsp";
        }
        if(role.equals("teacher")) {//老师登录
            Teacher teacher=userServiceInterface.findTeacherById(userId);
            if (teacher == null || !(teacher.getPassword().equals(password))) {
                return "loginError";
            }
            request.getSession().setAttribute("teacher",teacher);
            return "teacherIndex";
        }
        return "redirect:login.jsp";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(Student student) {// 可以直接通过javaBean对象传递
        userServiceInterface.addStudent(student);
        return "index";
    }

}
