package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserInfoController {

    @ResponseBody
    @RequestMapping("/StudentInfo")
    public ObjectJson studentInfo(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        Student[] students = new Student[1];
        students[0]=student;
        ObjectJson objectJson  = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(students.length);
        objectJson.setData(students);
        return objectJson;

    }
    @ResponseBody
    @RequestMapping("/TeacherInfo")
    public ObjectJson teacherInfo(HttpServletRequest request){
        Teacher student = (Teacher) request.getSession().getAttribute("teacher");
        Teacher[] students = new Teacher[1];
        students[0]=student;
        ObjectJson objectJson  = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(students.length);
        objectJson.setData(students);
        return objectJson;

    }
    @ResponseBody
    @RequestMapping("/UserExit")
    public ObjectJson userExit(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        return objectJson;
    }


}
