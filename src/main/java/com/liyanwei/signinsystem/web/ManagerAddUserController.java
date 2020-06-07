package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Course;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author lyw
 */
@Api(tags = "管理员添加信息接口")
@RestController
public class ManagerAddUserController {
    @Autowired
    private ManagerService managerService;

    @ApiOperation("添加学生信息")
    @PostMapping("/ManagerAddStudent")
    public ObjectJson addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sname = request.getParameter("sname");
        String spassword = request.getParameter("spassword");
        String sgender = request.getParameter("gender");
        String sbirthday = request.getParameter("birthday");
        String sidcard = request.getParameter("idcard");
        String sfaculty = request.getParameter("faculty");
        String sclass = request.getParameter("class");
        String snumber = request.getParameter("snumber");
        String sphone = request.getParameter("phone");
        String semail = request.getParameter("email");
        Student student = new Student(snumber, sname, spassword, sgender, sbirthday, sidcard, sfaculty, sclass, sphone, semail);
        Student student1 = managerService.selectStudentBySnum(snumber);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (student1 != null) {
            objectJson.setMsg("添加失败，学号已存在");
            return objectJson;
        } else {
            managerService.addStduent(student);
            objectJson.setMsg("添加成功");
            return objectJson;
        }
    }

    @ApiOperation("添加教师信息")
    @PostMapping("/ManagerAddTeacher")
    public ObjectJson addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String faculty = request.getParameter("faculty");
        String number = request.getParameter("number");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Teacher teacher = new Teacher(number, username, password, sex, birthday, idcard, faculty, phone, email);
        Teacher teacher1 = managerService.selectTeacherByTnum(number);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (teacher1 != null) {
            objectJson.setMsg("添加失败，工号已存在");
            return objectJson;
        } else {
            managerService.addTeacher(teacher);
            objectJson.setMsg("添加成功");

            return objectJson;
        }
    }


    @ApiOperation("添加课程信息")
    @PostMapping("/ManagerAddCourse")
    public ObjectJson addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cname = request.getParameter("cname");
        String cnumber = request.getParameter("cnumber");
        String ctime = request.getParameter("ctime");
        Course course = new Course(cnumber, cname, ctime);
        Map map = managerService.selectCourseByCnum(course.getCnumber());
        Course course1 = managerService.selectCourseByCname(course.getCname());
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (map != null) {
            objectJson.setMsg("添加失败，课程号已存在");
            return objectJson;
        } else if (course1 != null) {
            objectJson.setMsg("添加失败，课程名已存在");
            return objectJson;
        } else {
            managerService.addCourse(course);
            objectJson.setMsg("添加成功");
            return objectJson;
        }


    }
}
