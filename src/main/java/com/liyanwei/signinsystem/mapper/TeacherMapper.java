package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.SignSet;
import com.liyanwei.signinsystem.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherMapper {
     /**
      * 添加教师信息
      * @param teacher 教师信息
      *
      */
     void addTeacher(Teacher teacher);

     /**
      * 选取所有教师信息
      * @return teachers
      *
      */
     List<Teacher> selectAllTeachers();

     /**
      * 通过用户名密码查找教师，用来实现登陆功能
      * @param tname 教师姓名
      * @param tpassword 教师用户的密码
      * @return teacher
      *
      */
     Teacher selectTeacher(String tname,String tpassword);

     /**
      * 添加设置签到信息
      * @param signSet 教师设置签到的信息
      *
      */
     void addSignIn(SignSet signSet);

     /**
      * 通过用户名查找教师信息，并返回一个对象
      * @param tname 教师姓名
      * @return teacher
      *
      */
     Teacher selectTeacherByName(String tname);

     /**
      * 通过教师用户名查询教师信息，并返回一个集合
      * @param tname 教师用户名
      * @return List<Teacher> 查询到的教师信息
      */
     List<Teacher> selectTeacherByTname(String tname);
     List<Teacher> selectTeacherByFaculty(String tfaculty);
     /**
      * 通过教师工号查询教师信息
      * @param tnumber 教师工号
      * @return Teacher 教师信息
      */
     Teacher selectTeacherByTnum(String tnumber);
     /**
      * 通过教师工号和密码查询教师信息，用于教师用户登陆
      * @param tnumber 教师工号
      * @param tpassword 教师用户的密码
      * @return Teacher 返回一个Teacher对象
      */
     Teacher selectTeacherByNumAndPass(String tnumber,String tpassword);

     /**
      * 通过教师ID修改教师信息
      * @param teacher 教师对象
      */
     void updateTeacherById(Teacher teacher);

     /**
      * 通过教师ID删除教师信息
      * @param tid 教师信息ID
      */
     void deleteTeacherById(Integer tid);


}
