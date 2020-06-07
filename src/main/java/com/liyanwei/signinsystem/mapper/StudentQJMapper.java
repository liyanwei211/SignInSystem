package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.StudentQJ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentQJMapper {

    /**
     * 添加请假信息
     * @param studentQj 请假信息
     */
    void addStudentQj(StudentQJ studentQj);

    /**
     * 通过学号查询请假信息
     * @param snumber 学生学号
     * @return List<StudentQJ> 该学号所对应的请假信息集合
     */
    List<StudentQJ> selectStudentQjBySnum(String snumber);

    /**
     * 根据学生姓名查询请假信息
     * @param sname 学生姓名
     * @return List<StudentQJ> 根据学生姓名查询到的请假信息集合
     */
    List<StudentQJ> selectStudentQjBySname(String sname);

    /**
     * 根据学生班级查询请假信息
     * @param sclass 学生班级
     * @return List<StudentQJ> 根据学生班级查询到的请假信息
     */
    List<StudentQJ> selectStudentQjBySclass(String sclass);

    /**
     * 查询所有的请假信息
     * @return List<StudentQJ> 所有请假信息的集合
     */
    List<StudentQJ> selectAllStudentQjs();

    /**
     * 根据请假信息ID更新情请假信息ID
     * @param studentQj 新的学生请假信息
     */
    void updateStudentQjById(StudentQJ studentQj);

    /**
     * 根据请假信息ID删除请假信息
     * @param qjid 请假信息ID
     */
    void deleteStudentQjById(Integer qjid);

}
