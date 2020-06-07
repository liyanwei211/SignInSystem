package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Course;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.ManagerService;
import com.liyanwei.signinsystem.service.StudentService;
import com.liyanwei.signinsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ManagerUpdateController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ManagerService managerService;

    @ResponseBody
    @RequestMapping("/ManagerUpdateStudentById")
    public ObjectJson managerUpdateStudent(HttpServletRequest request, HttpServletResponse response){
        String sid = request.getParameter("sid");
        String email = request.getParameter("semail");
        String username = request.getParameter("sname");
        String sex = request.getParameter("sgender");
        String birthday = request.getParameter("sbirthday");
        String idcard = request.getParameter("sidcard");
        String faculty = request.getParameter("sfaculty");
        String sclass = request.getParameter("sclass");
        String number = request.getParameter("snumber");
        String phone = request.getParameter("sphone");
        String pass = request.getParameter("spassword");
        Student student1 = new Student();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");

        if (birthday!=null&&!"".equals(birthday)){
            student1.setSbirthday(birthday);
        }
        student1.setSpassword(pass);
        student1.setSnumber(number);
        student1.setSname(username);
        student1.setSgender(sex);
        student1.setSfaculty(faculty);
        student1.setSclass(sclass);
        student1.setSidcard(idcard);
        student1.setSid(Integer.parseInt(sid));
        student1.setSemail(email);
        student1.setSphone(phone);
        studentService.updateStudentById(student1);
        objectJson.setMsg("修改成功");
        return objectJson;
    }

    @ResponseBody
    @RequestMapping("/ManagerUpdateTeacher")
    public ObjectJson managerUpdateTeacher(HttpServletRequest request, HttpServletResponse response){
        String tid = request.getParameter("tid");
        String email = request.getParameter("temail");
        String username = request.getParameter("tname");
        String sex = request.getParameter("tgender");
        String birthday = request.getParameter("tbirthday");
        String idcard = request.getParameter("tidcard");
        String faculty = request.getParameter("tfaculty");
        String number = request.getParameter("tnumber");
        String phone = request.getParameter("tphone");
        String pass = request.getParameter("tpassword");
        Teacher teacher1 = new Teacher();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");

        if (birthday!=null&&!"".equals(birthday)){
            teacher1.setTbirthday(birthday);
        }
        teacher1.setTpassword(pass);
        teacher1.setTnumber(number);
        teacher1.setTname(username);
        teacher1.setTgender(sex);
        teacher1.setTfaculty(faculty);
        teacher1.setTid(Integer.parseInt(tid));
        teacher1.setTidcard(idcard);
        teacher1.setTphone(phone);
        teacher1.setTemail(email);
        teacherService.updateTeacherById(teacher1);
        objectJson.setMsg("修改成功");
        return objectJson;

    }

    @ResponseBody
    @RequestMapping("/ManagerUpdateCourse")
    public ObjectJson managerUpdateCourse(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        String cnumber = request.getParameter("cnumber");
        String cname = request.getParameter("cname");
        String ctime = request.getParameter("ctime");
        Course course = new Course();
        course.setCid(Integer.parseInt(cid));
        course.setCnumber(cnumber);
        course.setCname(cname);
        course.setCtime(ctime);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        managerService.managerUpdateCourse(course);
        objectJson.setMsg("修改成功");
        return objectJson;

    }





}
