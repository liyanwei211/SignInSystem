package com.liyanwei.signinsystem.web;


import com.liyanwei.signinsystem.bean.SignSet;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.common.SignSetRequest;
import com.liyanwei.signinsystem.service.ManagerService;
import com.liyanwei.signinsystem.service.StudentService;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "学生签到")
public class StudentSignInController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ManagerService managerService;



    @ApiOperation("学生进行签到信息")
    @RequestMapping("/StudentSignIn")
    public ObjectJson studentSignIn(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        String setId = request.getParameter("setId");
        String s = studentService.studentSignin(student.getSnumber(),Integer.parseInt(setId));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (s.equals("success")){
            objectJson.setMsg("签到成功");
        }else if (s.equals("failed")){
            objectJson.setMsg("已签到，请勿重复签到");
        }
        return objectJson;
    }
    @RequestMapping("/StudentSignInBySnum")
    public ObjectJson selectStudentSignInBySnum(HttpServletRequest request) throws ParseException {
        Student student = (Student) request.getSession().getAttribute("student");
        List<SignSet> signSetList = studentService.selectSignSetByClass(student.getSclass());
        SignSetRequest[] setRequests = new SignSetRequest[signSetList.size()];
        for (int i = 0; i < signSetList.size(); i++) {
            String cnumber = signSetList.get(i).getCnumber();
            String tnumber = signSetList.get(i).getTnumber();
            String classtime = signSetList.get(i).getClasstime();
            Map map = teacherService.selectCourseByCnum(cnumber);
            Teacher teacher = managerService.selectTeacherByTnum(tnumber);
            SignSetRequest sign = new SignSetRequest();
            sign.setSetId(signSetList.get(i).getId().toString());
            sign.setCname(map.get("c_name").toString());
            sign.setTname(teacher.getTname());
            sign.setClasstime(signSetList.get(i).getClasstime());
            setRequests[i] = sign;
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(setRequests.length);
        objectJson.setData(setRequests);
        return objectJson;
    }


}
