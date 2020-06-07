package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "教师用户注册")
@RestController
public class TeacherRegisterController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("教师用户注册")
    @PostMapping("/TeacherRegister")
   public void TeacherRegister(String tnumber,String username, String password, String gender, String birthday, String idcard, String faculty, String phone, String email){
        Teacher teacher = new Teacher(tnumber,username,password,gender,birthday,idcard,faculty,phone,email);
        teacherService.addTeacherService(teacher);
        System.out.println("success!!!!");
    }
}
