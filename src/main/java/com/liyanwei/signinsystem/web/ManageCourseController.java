package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.CourseVideo;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.mapper.CourseVideoMapper;
import com.liyanwei.signinsystem.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lyw
 */
@Api(tags = "管理员管理课程接口")
@RestController
public class ManageCourseController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private CourseVideoMapper courseVideoMapper;

    @ApiOperation("查询所有课程信息")
    @RequestMapping("/SelectAllCV")
    public ObjectJson selectAllCourses(){
        List<CourseVideo> courseVideos = managerService.selectAllCv();
        CourseVideo[] cv = new CourseVideo[courseVideos.size()];
        for (int i = 0; i < courseVideos.size(); i++) {
            cv[i] = courseVideos.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("");
        objectJson.setCount(courseVideos.size());
        objectJson.setData(cv);
        return objectJson;

    }

    @ApiOperation("根据ID删除课程信息")
    @RequestMapping("/DeleteCourseById/{cid}")
    public ObjectJson deleteCourseById(@PathVariable String cid){
        managerService.deleteCourseById(Integer.parseInt(cid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }
    @RequestMapping("/DeleteCourseVideoById/{vid}")
    public ObjectJson deleteCourseVideoById(@PathVariable String vid){
        courseVideoMapper.deleteVideoById(Integer.parseInt(vid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;

    }

}
