package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Manager;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.service.ManagerService;
import com.liyanwei.signinsystem.service.ManagerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;

@Api(tags = "管理员用户注册")
@RestController
public class ManagerRegisterController {

    @Autowired
    private ManagerService managerService;

    @ApiOperation("管理员用户注册")
    @ResponseBody
    @PostMapping("/ManagerRegister")
   public void managerRegister(String mnumber,String username, String password, String gender, String birthday, String idcard, String phone, String email) throws ParseException {
        //接受注册页面传来的数据
       /* String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String gender = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");*/
        //将学生信息封装到学生类中
        Manager manager = new Manager(mnumber,username,password,gender,birthday,idcard,phone,email);
        managerService.addManagerService(manager);
        System.out.println("success!!!!");
    }
}
