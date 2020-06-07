package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.StudentQJ;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "学生请假管理")
@RestController
public class StudentQJController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("添加学生请假信息")
    @RequestMapping("/AddStudentQj")
    public ObjectJson addStudentQj(HttpServletRequest request){
        String number = request.getParameter("number");
        String username = request.getParameter("username");
        String sclass = request.getParameter("class");
        String date = request.getParameter("date");
        String reason = request.getParameter("desc");
        StudentQJ qj = new StudentQJ();
        qj.setSnumber(number);
        qj.setSname(username);
        qj.setSclass(sclass);
        qj.setQjtime(date);
        qj.setQjreason(reason);
        qj.setQjstatus("未审核");
        studentService.addStudentQjService(qj);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("提交成功");
        return objectJson;

    }

    @ApiOperation("根据学号查询请假信息")
    @RequestMapping("/SelectStudentQjBySnum")
    public ObjectJson selectStudentQjBySnum(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        List<StudentQJ> studentQJS = studentService.selectStudentQjBySnumService(student.getSnumber());
        StudentQJ[] qjs = new StudentQJ[studentQJS.size()];
        for (int i = 0; i < studentQJS.size(); i++) {
            qjs[i] = studentQJS.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(qjs.length);
        objectJson.setData(qjs);
        return objectJson;
    }

    @RequestMapping("/SelectStudentQjByStatus/{qjstatus}")
    public ObjectJson selectStudentQjByStatus(HttpServletRequest request, @PathVariable String qjstatus){
        Student student = (Student) request.getSession().getAttribute("student");
        List<StudentQJ> studentQJS = studentService.selectStudentQjBySnumService(student.getSnumber());
        List<StudentQJ> qjs = new ArrayList<>();
        for (int i = 0; i < studentQJS.size(); i++) {
            if (qjstatus.equals(studentQJS.get(i).getQjstatus())){
                qjs.add(studentQJS.get(i));
            }
        }
        StudentQJ[] qjs1 = new StudentQJ[qjs.size()];
        for (int i = 0; i < qjs.size(); i++) {
            qjs1[i]=qjs.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(qjs1.length);
        objectJson.setData(qjs1);
        return objectJson;
    }



}
