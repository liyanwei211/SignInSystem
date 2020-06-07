package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.common.SignInRequest;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@Api(tags = "教师添加签到信息")
public class TeacherSignInController {

    @Autowired
    public TeacherService teacherService;
    @ApiOperation("添加签到信息")
    @RequestMapping("/addSignIn")
    public ObjectJson addSignIn(HttpServletRequest request, @RequestParam(value = "course")String cname, @RequestParam(value = "teacher")String tname, @RequestParam(value = "date")String classtime, @RequestParam(value = "class")String classnumber, @RequestParam(value = "studentnum") String pnumber){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        request.getSession().setAttribute("cname",cname);
        request.getSession().setAttribute("classtime",classtime);

        String s = teacherService.addSignIn(cname, teacher.getTnumber(), classtime, classnumber, Integer.parseInt(pnumber));

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg(s);
        return objectJson;
    }

    @RequestMapping("/SelectSignRecordByCtname")
    public ObjectJson selectSignRecordByCtname(HttpServletRequest request) throws ParseException {
        String cname = (String) request.getSession().getAttribute("cname");
        String classtime = (String) request.getSession().getAttribute("classtime");
        ObjectJson objectJson = new ObjectJson();
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (classtime==null||cname==null){
            objectJson.setCode("200");
            objectJson.setMsg("");
            return objectJson;
        }
        SignInRequest[] signInRequests = teacherService.selectSignRecordForTeacher(cname, teacher.getTnumber(), classtime);

        objectJson.setCode("200");
        objectJson.setMsg("添加签到设置成功");
        objectJson.setCount(signInRequests.length);
        objectJson.setData(signInRequests);
        return objectJson;
    }


}
