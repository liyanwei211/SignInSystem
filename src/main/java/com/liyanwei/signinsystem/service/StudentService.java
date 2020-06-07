package com.liyanwei.signinsystem.service;

import com.liyanwei.signinsystem.bean.*;
import com.liyanwei.signinsystem.common.SignInRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author liyanwei
 */
@Service
public interface StudentService {

    /**
     * 添加学生
     * @param student 输入的学生信息
     *
     */
     void addStudentService(Student student);

    /**
     * Student Login
     * @param snumber 学生学号
     * @param spassword 学生输入的密码
     * @return Student 返回一个Student对象
     * 学生登陆
     */
     Student studentLogin(String snumber, String spassword);

    /**
     * 查询所有学生
     * @return List<Student> 学生信息集合
     *
     */
     List<Student> selectAllStudents();

    /**
     * 学生签到功能
     * @param snumber 学生学号
     *
     * @return
     */

    String studentSignin(String snumber, Integer setId);

    /**
     * 查询全部的课程视频信息
     * @return List<CourseVideo> 课程视频信息集合
     *
     */
    List<CourseVideo> selectAllCourseVideo();

    /**
     * 添加学生请假信息
     * @param studentQj 学生请假信息
     */
    void addStudentQjService(StudentQJ studentQj);

    /**
     * 根据学生学号查询请假信息
     * @param snumber 学生学号
     * @return
     */
    List<StudentQJ> selectStudentQjBySnumService(String snumber);

    /**
     * @param sclass
     * @return
     */
    List<SignSet> selectSignSetByClass(String sclass) throws ParseException;

    /**
     * 根据学号查询签到信息
     * @param snumber 学生学号
     * @return List<SignRecord> 签到信息集合
     */
    SignInRequest[] selectSignRecordBySnum(String snumber) throws ParseException;

    /**
     * 添加学生选课信息
     * @param number 学号
     * @param cnumber 课程号
     * @param charactor 角色
     */
    void addStudentCc(String number,String cnumber,String charactor);

    /**
     * 根据学号查询课程信息
     * @param number 学号
     * @return List<Ccourse> 查询到的课程信息集合
     */
    List<Map> selectStudentCc(String number);

    /**
     * @param number
     * @param cnumber
     * @return
     */
    Ccourse selectStudentCcByNumAndCnum(String number,String cnumber);

    /**
     * 根据选课信息ID删除选课信息
     * @param ccid 选课信息ID
     */
    void deleteStudentCc(Integer ccid);

    /**
     * 查询所有选课信息
     * @return
     */
    List<Map> selectAllCourse();

    /**
     * @param student
     */
    void updateStudentById(Student student);

}
