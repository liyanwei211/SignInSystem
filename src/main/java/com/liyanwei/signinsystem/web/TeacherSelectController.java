package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Course;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.common.CourseRequest;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lyw
 */
@Api(tags = "教师查询接口")
@RestController
public class TeacherSelectController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("根据学号查询学生信息")
    @ResponseBody
    @RequestMapping("/SelectStudentBySnum/{snumber}")
    public ObjectJson selectStudentBySnum(@PathVariable String snumber){
        System.out.println(snumber);
        Student student = teacherService.selectStudentBySnumService(snumber);
        Student[] students  = new Student[1];
        students[0] = student;
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(students.length);
        objectJson.setData(students);
        return objectJson;

    }
    @ApiOperation("根据学生姓名查询学生信息")
    @RequestMapping("/SelectStudentBySname/{sname}")
    public ObjectJson selectStudentBySname(@PathVariable String sname){
        List<Student> students = teacherService.selectStudentBySnameService(sname);
        Student[] student1s  = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            student1s[i] = students.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(students.size());
        objectJson.setData(student1s);
        return objectJson;
    }

    @ApiOperation("根据课程号查询课程信息")
    @RequestMapping("/SelectCourseByCnum/{cnumber}")
    public ObjectJson selectCourseByCnum(@PathVariable String cnumber){
        Map course = teacherService.selectCourseByCnum(cnumber);
        CourseRequest[] courseRequests = new CourseRequest[1];
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setCid(Integer.parseInt(course.get("c_id").toString()));
        courseRequest.setCnumber(course.get("c_number").toString());
        courseRequest.setCname(course.get("c_name").toString());
        courseRequest.setCtime(course.get("c_time").toString());
        courseRequests[0] = courseRequest;
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(courseRequests.length);
        objectJson.setData(courseRequests);
        return objectJson;


    }
    @ApiOperation("根据课程名称查询课程信息")
    @RequestMapping("/SelectCourseByCname/{cname}")
    public ObjectJson selectCourseByCname(@PathVariable String cname){
        Course course = teacherService.selectCourseByCname(cname);
        Course[] courses = new Course[1];
        courses[0] = course;
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(courses.length);
        objectJson.setData(courses);
        return objectJson;
    }




}
