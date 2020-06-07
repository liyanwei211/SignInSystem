package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.SignRecord;
import com.liyanwei.signinsystem.bean.SignSet;
import com.liyanwei.signinsystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生DAO接口
 * @author liyanwei
 */

@Repository
public interface StudentMapper {

    /**
     * @param s 传入学生类形参
     * 添加学生信息
     */
    void addStudent(Student s);

    /**
     * @return Students 返回所有学生的List集合
     * 查询所有学生
     */
    List<Student> selectAllStudents();

    /**
     * @param sfaculty
     * @return
     */
    List<Student> selectStudentsByFaculty(String sfaculty);

    /**
     * @param sclass
     * @return
     */
    List<Student> selectStudentsBySclass(String sclass);

    /**
     *
     * @param sname
     * @param spassword
     * @return student
     * 通过用户名和密码查询学生，用于学生登陆
     */
    Student selectStudent(String sname, String spassword);

    /**
     * @param record
     * 学生进行签到操作
     */
    void studentSignin(SignRecord record);

    /**
     * 通过学号查找学生
     * @param snumber 学生学号
     * @return Student
     *
     */
    Student selectStudentBySnumber(String snumber);

    /**
     * 通过学生班级查找签到信息
     * @param sclass 班级
     * @return SignSet
     *
     */
    List<SignSet> selectSignSetByClass(String sclass);

    /**
     * 根据setId查询签到设置信息
     * @param setId
     * @return
     */
    SignSet selectSignSetBySetId(Integer setId);
    SignSet selectSignSetByCtname(String cnumber,String tnumber,String classtime);

    /**
     * 通过学号查询学生签到信息
     * @param snumber 学生学号
     * @return List<SignRecord> 学生签到信息集合
     */
    List<SignRecord> selectSignRecordBySnum(String snumber);

    /**
     *
     * @return
     */
    SignRecord selectSignRecordBySnumAndSetId(SignRecord record);

    /**
     * 通过学号和密码查询学生信息
    * @param student 需要查询的学生信息
     * @return Student 查询到的学生信息
     *
     */
    Student selectStuBySnoAndPass(Student student);

    /**
     * 通过姓名查找学生信息
     * @param sname 学生姓名
     * @return List<Student> 学生信息集合
     */
    List<Student> selectStudentBySname(String sname);

    /**
     * 通过学生信息ID修改学生信息
     * @param student 学生信息对象
     */
    void updateStudentById(Student student);

    /**
     * 通过学生信息ID删除学生信息
     * @param sid 学生信息ID
     */
    void deleteStudentById(Integer sid);
    List<SignRecord> selectSignRecordBySetId(Integer setId);


}
