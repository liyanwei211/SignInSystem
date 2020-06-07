package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.CourseVideo;
import com.liyanwei.signinsystem.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生课程视频管理
 * @author lyw
 */
@Api(tags = "学生课程视频管理")
@RestController
public class StudentCVController {

    @Autowired
    private StudentService studentService;

    /**
     * 选择所有课程
     */
    @ApiOperation("选择所有课程")
    @ResponseBody
    @PostMapping("/SelectAllVideo")
    public void selectAllVideo(){
        List<CourseVideo> courseVideos = studentService.selectAllCourseVideo();
        for (CourseVideo video: courseVideos) {
            System.out.println(video.toString());
        }
    }
    @ApiOperation("选择今日课程")
    @ResponseBody
    @PostMapping("/SelectTodayVideo")
    public void selectTodayVideo(){

    }



}
