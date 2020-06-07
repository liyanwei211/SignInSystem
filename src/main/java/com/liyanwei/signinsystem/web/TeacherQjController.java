package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.StudentQJ;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.mapper.StudentQJMapper;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "教师请假管理")
@RestController
public class TeacherQjController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentQJMapper studentQJMapper;

    @ApiOperation("修改请假信息状态")
    @RequestMapping("/UpdateStudentQJ")
    public ObjectJson updateStudentQj(HttpServletRequest request, HttpServletResponse response){
        String qjid = request.getParameter("qjid");
        String qjstatus = request.getParameter("qjstatus");
        teacherService.updateStudentQjService(qjid, qjstatus);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("修改成功");
        return objectJson;
    }
    @RequestMapping("/SelectStudentQjBySname")
    public ObjectJson selectStudentQjBySnum(String sname){
        StudentQJ[] qjs = teacherService.selectStudentQjBySname(sname);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(qjs.length);
        objectJson.setData(qjs);
        return objectJson;
    }
    @RequestMapping("/SelectAllStudentQj")
    public ObjectJson selectAllStudentQj(){
        StudentQJ[] studentQJS = teacherService.selectAllStudentQj();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(studentQJS.length);
        objectJson.setData(studentQJS);
        return objectJson;
    }

    @RequestMapping("/SelectQJByClass/{sclass}")
    public ObjectJson selectStudentQjByClass(@PathVariable String sclass){
        List<StudentQJ> studentQJS = studentQJMapper.selectStudentQjBySclass(sclass);
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


}
