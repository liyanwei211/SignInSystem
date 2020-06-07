package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.CourseVideo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程视频映射接口
 * @author lyw
 */
@Repository
public interface CourseVideoMapper {

    /**
     * 添加课程视频信息
     * @param video 课程视频对象
     */
    void addCourseVideo(CourseVideo video);

    /**
     * 通过课程号查询课程视频
     * @param cnumber 课程号
     * @return CourseVideo 课程视频对象
     */
    CourseVideo selectVideoByCnum(String cnumber);

    /**
     * 通过教师工号查找课程信息
     * @param tnumber 教师工号
     * @return CourseVideo 课程视频对象
     */
    List<CourseVideo> selectVideoByTnum(String tnumber);

    /**
     * 查询所有的课程视频信息
     * @return List<CourseVideo> 课程视频信息集合
     */
    List<CourseVideo> selectAllCourseVideo();
    /**
     * 根据课程视频ID删除课程视频
     * @param vid 课程视频ID
     */
    void deleteVideoById(Integer vid);
}
