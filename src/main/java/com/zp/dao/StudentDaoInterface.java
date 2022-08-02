package com.zp.dao;

import com.zp.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDaoInterface {

  List<Student> findAllStudent();

  List<String> findAllStudentId();

  void updateStudent(Student student);

  void deleteStudent(String studentId);

  void updateScore(@Param("score") Integer score,@Param("studentName") String studentName);

  int selectMaxScore();

  int selectMinScore();

  int countStudent();

  int sumScore();
}
