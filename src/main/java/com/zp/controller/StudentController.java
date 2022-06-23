package com.zp.controller;

import com.zp.entity.Student;
import com.zp.entity.Subject;
import com.zp.service.StudentServiceInterface;
import com.zp.service.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class StudentController {

    @Autowired
    SubjectServiceInterface subjectServiceInterface;
    @Autowired
    StudentServiceInterface studentServiceInterface;
    /*
     * 学生后台管理逻辑
     * */
    @RequestMapping("/exam")
    public String exam(@RequestParam(value="pn",defaultValue="1")int num , HttpSession session) {
        int pageSize=10;
        List<Subject> subjects=subjectServiceInterface.randomFindSubject();
        List<Integer> subjectIds=new ArrayList<Integer>();
        for(Subject subject:subjects) {
            subjectIds.add(subject.getSubjectId());
        }
        session.setAttribute("subjects",subjects);
        session.setAttribute("subjectIds", subjectIds);
        return "exam";
    }


    @RequestMapping(value="/getScore",method=RequestMethod.POST)
    public String getScore(HttpServletRequest request, HttpSession session) {
        int score=0;
//        获取学生姓名
        Student student = (Student) session.getAttribute("student");
        String stuName = student.getStudentName();
        List<Integer> subjectIds=(List<Integer>) session.getAttribute("subjectIds");
        List<String> userAnswers=new ArrayList<String>();
        List<String> subjectAnswers=new ArrayList<String>();
//        获取题目数量
        int j = subjectIds.size();
//        获取用户选择
        for(int i=0;i<j;i++) {
            userAnswers.add(request.getParameter("subjectOption-"+subjectIds.get(i)));
        }
//        从数据库中获取答案
        for(int i=0;i<j;i++) {
            subjectAnswers.add(subjectServiceInterface.findSubjectById(subjectIds.get(i)).getSubjectAnswer());
        }
        for(int i=0;i<j;i++) {
            if((userAnswers.get(i)).equals(subjectAnswers.get(i))) {
                score+=100/j;
            }
            else {
                score+=0;
            }
        }
        session.setAttribute("score",score);
//        将分数存入数据库
        studentServiceInterface.updateScore(score,stuName);
        return "score";

    }

    @RequestMapping("/statisticalScore")
    public ModelAndView statisticalScore(ModelAndView modle){
        int maxScore,minScore,countStudent,sumScore,averageScore;
        Map<String,Object> score = new HashMap<>();
//        从数据库获取学生人数
        countStudent = studentServiceInterface.countStudent();
//        从数据库获取总分数
        sumScore = studentServiceInterface.sumScore();
//        从数据库获取最高分
        maxScore = studentServiceInterface.selectMaxScore();
//        从数据库获取最低分
        minScore = studentServiceInterface.selectMinScore();
//                计算平均分
        averageScore = sumScore/countStudent;

        score.put("countStudent",countStudent);
        score.put("sumScore",sumScore);
        score.put("maxScore",maxScore);
        score.put("minScore",minScore);
        score.put("averageScore",averageScore);
        modle.addObject("score",score);
        modle.setViewName("statistical");
        return modle;
    }
}
