package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.service.StudentService;
import com.liyanwei.signinsystem.service.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

/**
 * @author lyw
 */
@Api(tags = "学生用户注册")
@RestController
public class StudentRegisterController extends HttpServlet {

    @Autowired
    StudentService studentService;

    @ApiOperation("用户注册")
    @PostMapping("/html/StudentRegister")
   public void stduentRegister(String snumber,String username,String password,String gender,String birthday,String idcard,String faculty,String sclass,String phone,String email) throws ParseException {
        //接受注册页面传来的数据
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String gender = request.getParameter("sex");
        String faculty = request.getParameter("faculty");
        String sclass = request.getParameter("sclass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");*/
        //将学生信息封装到学生类中
        Student student = new Student(snumber,username,password,gender,birthday,idcard,faculty,sclass,phone,email);
        studentService.addStudentService(student);
        System.out.println("success!!!!");
    }
}
