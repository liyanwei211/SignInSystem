package com.liyanwei.signinsystem.web;

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
public class UpdateController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ManagerService managerService;

    @ResponseBody
    @RequestMapping("/UpdateStudentById")
    public ObjectJson updateStudentById(HttpServletRequest request, HttpServletResponse response){
        Student student = (Student) request.getSession().getAttribute("student");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String faculty = request.getParameter("faculty");
        String sclass = request.getParameter("class");
        String number = request.getParameter("number");
        String phone = request.getParameter("phone");
        String nowpass = request.getParameter("nowpass");
        String pass = request.getParameter("pass");
        Student student1 = new Student();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (nowpass!=null&&pass!=null){
            if (nowpass.equals(student.getSpassword())){
                student1.setSpassword(pass);
            }else{
                objectJson.setMsg("当前密码有误");
                return objectJson;
            }
        }
        if (birthday!=null&&!"".equals(birthday)){
            student1.setSbirthday(birthday);
        }
        student1.setSnumber(number);
        student1.setSname(username);
        student1.setSgender(sex);
        student1.setSfaculty(faculty);
        student1.setSclass(sclass);
        student1.setSidcard(idcard);
        student1.setSid(student.getSid());
        student1.setSemail(email);
        student1.setSphone(phone);
        studentService.updateStudentById(student1);
        objectJson.setMsg("修改成功");
        return objectJson;
    }
    @ResponseBody
    @RequestMapping("/UpdateTeacherById")
    public ObjectJson updateTeacherById(HttpServletRequest request, HttpServletResponse response){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String faculty = request.getParameter("faculty");
        String number = request.getParameter("number");
        String phone = request.getParameter("phone");
        String nowpass = request.getParameter("nowpass");
        String pass = request.getParameter("pass");
        Teacher teacher1 = new Teacher();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (nowpass!=null&&pass!=null){
            if (nowpass.equals(teacher.getTpassword())){
                teacher1.setTpassword(pass);
            }else{
                objectJson.setMsg("当前密码有误");
                return objectJson;
            }
        }
        if (birthday!=null&&!"".equals(birthday)){
            teacher1.setTbirthday(birthday);
        }
        teacher1.setTnumber(number);
        teacher1.setTname(username);
        teacher1.setTgender(sex);
        teacher1.setTfaculty(faculty);
        teacher1.setTid(teacher.getTid());
        teacher1.setTidcard(idcard);
        teacher1.setTphone(phone);
        teacher1.setTemail(email);
        teacherService.updateTeacherById(teacher1);
        objectJson.setMsg("修改成功");
        return objectJson;

    }


}
