package com.liyanwei.signinsystem.web;


import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.StudentQJ;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.common.QjRequest;
import com.liyanwei.signinsystem.common.SignInRequest;
import com.liyanwei.signinsystem.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyw
 */
@Api(tags = "学生查询模块")
@RestController
public class StudentSelectController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("学生查询签到信息")
    @RequestMapping("/SelectSignRecord")
    public ObjectJson selectSignRecord(HttpServletRequest request) throws ParseException {
        Student student = (Student) request.getSession().getAttribute("student");
        String snumber = student.getSnumber();
        SignInRequest[] signRecords = studentService.selectSignRecordBySnum(snumber);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(signRecords.length);
        objectJson.setData(signRecords);
        return objectJson;
    }

    @RequestMapping("/SelectSignRecordByCname/{cname}")
    public ObjectJson selectSignRecordByCname(HttpServletRequest request, @PathVariable String cname) throws ParseException {
        Student student = (Student) request.getSession().getAttribute("student");
        String snumber = student.getSnumber();
        SignInRequest[] signRecords = studentService.selectSignRecordBySnum(snumber);
        List<SignInRequest> sign = new ArrayList<>();
        for (int i = 0; i < signRecords.length; i++) {
            if (cname.equals(signRecords[i].getCname())){
                sign.add(signRecords[i]);
            }
        }
        SignInRequest[] signInRequests = new SignInRequest[sign.size()];
        for (int i = 0; i < sign.size(); i++) {
            signInRequests[i] = sign.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(signInRequests.length);
        objectJson.setData(signInRequests);
        return objectJson;
    }

    @ApiOperation("学生查询请假信息")
    @RequestMapping("/SelectStudentQj")
    public ObjectJson selectStudentQj(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        List<StudentQJ> studentQJS = studentService.selectStudentQjBySnumService(student.getSnumber());

        QjRequest[] qjRequests = new QjRequest[studentQJS.size()];
        for (int i = 0; i < studentQJS.size(); i++) {
            QjRequest qj = new QjRequest();
            qj.setSnumber(studentQJS.get(i).getSnumber());
            qj.setSname(studentQJS.get(i).getSname());
            qj.setSclass(studentQJS.get(i).getSclass());
            qj.setQjtime(studentQJS.get(i).getQjtime());
            qj.setQjreason(studentQJS.get(i).getQjreason());
            qj.setStatus(studentQJS.get(i).getQjstatus());
            qjRequests[i]=qj;
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(studentQJS.size());
        objectJson.setData(qjRequests);
        return objectJson;

    }


}
