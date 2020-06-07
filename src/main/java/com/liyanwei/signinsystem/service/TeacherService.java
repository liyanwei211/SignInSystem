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
public interface TeacherService {

    /**
     * @param
     * @return
     * 添加教师信息
     */
    public void addTeacherService(Teacher teacher);

    /**
     * 教师登陆功能实现
     * @param tnumber 教师工号
     * @param tpassword 教师用户的密码
     * @return Teacher 返回一个教师对象
     *
     */
    public Teacher teacherLogin(String tnumber, String tpassword);

    /**
     * 添加设置签到信息
     * @param cname 课程名称
     * @param tname 教师名称
     * @param classtime 上课时间
     * @param classnumber 上课班级
     * @param pnumber 上课人数
     *
     * @return
     */
    String addSignIn(String cname, String tname, String classtime, String classnumber, int pnumber);


    /**
     * 添加课程视频信息
     * @param cname 课程名称
     * @param tname 教师名称
     * @param coursetime 上课时间
     * @param vvideo 课程视频
     * 课程名称用于查询课程号
     * 教师名称用户查询教师工号
     */
    void addCourseVideoService(String cname,String tname,String coursetime,String vvideo);

    /**
     * 通过课程视频ID删除课程视频
     * @param vid 课程视频ID
     */
    void deleteCourseVideoService(Integer vid);

    /**
     * 教师通过学号查询请假信息并修改请假信息的状态
     * @param qjid 请假ID 用于查询请假信息
     * @param qjstatus 请假信息状态
     */
    void updateStudentQjService(String qjid,String qjstatus);

    /**
     * 通过学号查询学生信息学生信息
     * @param snumber 学生学号
     * @return Student 学生信息
     */
    Student selectStudentBySnumService(String snumber);

    /**
     * 通过学生姓名查询学生信息
     * @param sname 学生姓名
     * @return List<Student> 查询到的学生信息结合
     */
    List<Student> selectStudentBySnameService(String sname);

    /**
     * 根据课程号查询课程信息
     * @param cnumber 课程号
     * @return Course 查询到的课程信息
     */
    Map selectCourseByCnum(String cnumber);

    /**
     * 根据课程名称查询课程信息
     * @param cname 课程名称
     * @return Course 查询到的课程信息
     */
    Course selectCourseByCname(String cname);

    /**
     * @param sname
     * @return
     */
    StudentQJ[] selectStudentQjBySname(String sname);

    /**
     * @return
     */
    StudentQJ[] selectAllStudentQj();
    /**
     * 添加教师选课信息
     * @param number 工号
     * @param cnumber 课程号
     * @param charactor 角色
     */
    void addTeacherCc(String number,String cnumber,String charactor);

    /**
     * 根据工号查询课程信息
     * @param number 工号
     * @return List<Ccourse> 查询到的课程信息集合
     */
    List<Ccourse> selectTeacherCc(String number);

    /**
     * 根据选课信息ID删除选课信息
     * @param ccid 选课信息ID
     */
    void deleteTeacherCc(Integer ccid);

    /**
     * @param teacher
     */
    void updateTeacherById(Teacher teacher);

    /**
     * @param cname
     *
     * @param classtime
     * @return
     */
    SignInRequest[] selectSignRecordForTeacher(String cname, String tnumber, String classtime) throws ParseException;


}
