package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Manager;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.ManagerService;
import com.liyanwei.signinsystem.service.StudentService;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyanwei
 */
@RestController
@Api(tags = "用户登录接口")
public class UserLoginController extends HttpServlet {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ManagerService managerService;

    @ApiOperation("用户登录")
    @ResponseBody
    @RequestMapping("/html/UserLogin")
   public ObjectJson userLogin (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        ObjectJson objectJson = new ObjectJson();
        switch (user){
            case "学生":
                Student student = studentService.studentLogin(number, password);
                if (student==null){
                    objectJson.setCode("200");
                    objectJson.setMsg("用户名或密码错误");
                    objectJson.setData(null);
                    objectJson.setCount(0);
                    response.sendRedirect(request.getContextPath()+"login.html");
                    return objectJson;
                }else {
                    request.getSession().setAttribute("student",student);
                    response.sendRedirect(request.getContextPath()+"user/index.html");
                    objectJson.setCode("200");
                    objectJson.setMsg("success");

                }
                break;
            case "教师":
                Teacher teacher = teacherService.teacherLogin(number, password);
                if (teacher==null){
                    objectJson.setCode("200");
                    objectJson.setMsg("用户名或密码错误");
                    objectJson.setData(null);
                    objectJson.setCount(0);
                    response.sendRedirect(request.getContextPath()+"login.html");
                    return objectJson;
                }else {
                    request.getSession().setAttribute("teacher",teacher);
                    response.sendRedirect(request.getContextPath()+"teacher/index.html");
                }
                break;
            case "管理员":
                Manager manager = managerService.managerLogin(number, password);
                if (manager==null){
                    objectJson.setCode("200");
                    objectJson.setMsg("用户名或密码错误");
                    objectJson.setData(null);
                    objectJson.setCount(0);
                    response.sendRedirect(request.getContextPath()+"login.html");
                    return objectJson;
                }else {
                    request.getSession().setAttribute("manager",manager);
                    response.sendRedirect(request.getContextPath()+"manager/index.html");

                }
                break;
            default:
                break;

        }
        return null;
    }
}
