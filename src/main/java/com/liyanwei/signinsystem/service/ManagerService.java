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
public interface ManagerService {

    /**
     * 添加管理员信息
     * @param manager 管理对象
     *
     */
    void addManagerService(Manager manager);

    /**
     *  管理员登陆
     * @param mnumber 管理员工号
     * @param mpassword 管理员密码
     * @return manager 管理员对象
     */
    Manager managerLogin(String mnumber, String mpassword);

    /**
     * 通过学号查询学生信息
     * @param snumber 学生学号
     * @return Student 学生信息
     */
    Student selectStudentBySnum(String snumber);

    /**
     * 通过学生姓名查询学生信息
     * @param sname 学生姓名
     * @return List<Student> 学生信息集合
     */
    List<Student> selectStudentBySname(String sname);

    /**
     * @param sfaculty
     * @return
     */
    List<Student> selectStudentByfaculty(String sfaculty);

    /**
     * @param sclass
     * @return
     */
    List<Student> selectStudentBySclass(String sclass);

    /**
     * @param tfaculty
     * @return
     */
    List<Teacher> selectTeacherByFaculty(String tfaculty);

    /**
     * 查询所有的学生信息
     * @return List<Student>
     */
    List<Student> selectAllStudents();

    /**
     * 根据教师工号查询教师信息
     * @param tnumber 教师工号
     * @return Teacher 查询到的教师信息
     */
    Teacher selectTeacherByTnum(String tnumber);

    /**
     * 根据教师姓名查询教师信息
     * @param Tname 教师姓名
     * @return List<Teacher> 查询到的教师信息
     */
    List<Teacher> selectTeacherByTname(String Tname);

    /**
     * 查询所有教师信息
     * @return 查询到的教师信息
     */
    List<Teacher> selectAllTeachers();

    /**
     * 通过课程号查询课程信息
     * @param cnumber 课程号
     * @return Course 查询到的课程信息
     */
    Map selectCourseByCnum(String cnumber);

    /**
     * 通过课程名称查寻课程信息
     * @param cname 课程名称
     * @return Course 查询到的课程信息
     */
    Course selectCourseByCname(String cname);

    /**
     * 查询所有课程信息
     * @return List<Course> 查询到的课程信息集合
     */
    List<Map> selectAllCourse();

    /**
     * 查询所有的签到信息
     * @return  List<SignRecord> 查询到的签到信息
     */
    SignInRequest[] selectAllSignInRecord() throws ParseException;

    /**
     * 查询所有的请假信息
     * @return List<StudentQJ> 查询到的请假信息
     */
    List<StudentQJ> selectAllStudentQj();

    /**
     * @return
     */
    List<CourseVideo> selectAllCv();

    /**
     * 添加学生信息
     * @param student 学生信息
     */
    void addStduent(Student student);

    /**
     * 添加教师信息
     * @param teacher 教师信息
     */
    void addTeacher(Teacher teacher);

    /**
     * 添加课程信息
     * @param course 课程信息
     */
    void addCourse(Course course);

    /**
     * 通过学生ID删除学生信息
     * @param sid 学生ID
     */
    void deleteStudentById(Integer sid);

    /**
     * 通过教师ID删除教师信息
     * @param tid 教师ID
     */
    void deleteTeacherById(Integer tid);

    /**
     * 通过课程ID删除课程信息
     * @param cid 课程ID
     */
    void deleteCourseById(Integer cid);

    /**
     * 通过签到信息ID删除签到信息
     * @param qdid 签到信息ID
     */
    void deleteSignInById(Integer qdid);

    /**
     * 通过ID删除请假信息
     * @param qjid 请假信息ID
     */
    void deleteStudentQjById(Integer qjid);

    void managerUpdateCourse(Course course);



}
