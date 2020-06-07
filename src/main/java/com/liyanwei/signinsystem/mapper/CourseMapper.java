package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.Course;
import com.liyanwei.signinsystem.bean.Manager;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lyw
 */
@Repository
public interface CourseMapper {
    /**
     * 添加课程信息
     * @param course 课程对象
     */
    void addCourse(Course course);

    /**
     * 查询所有课程信息
     * @return List<Course> 返回课程信息的集合
     */
    List<Map> selectAllCourses();

    /**
     * 通过课程名称查询课程
     * @param cname 课程名称
     * @return 返回一个课程对象
     */
    Course selectCourseByName(String cname);

    /**
     * 通过课程号查询课程信息
     * @param cnumber 课程号
     * @return Course 查询到的课程信息
     */
    Map selectCourseByCnum(String cnumber);

    /**
     * 根据课程ID更新课程信息
     * @param course 课程信息对象
     */
    void updateCourseById(Course course);

    /**
     * 根据课程ID删除课程信息
     * @param cid 课程ID
     */
    void deleteCourseById(Integer cid);
}
