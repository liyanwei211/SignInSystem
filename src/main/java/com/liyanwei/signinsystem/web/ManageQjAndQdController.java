package com.liyanwei.signinsystem.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liyanwei.signinsystem.bean.StudentQJ;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.common.SignInRequest;
import com.liyanwei.signinsystem.service.ManagerService;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author lyw
 */
@Api(tags = "管理签到和请假信息接口")
@RestController
public class ManageQjAndQdController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("选择所有签到信息")
    @RequestMapping("/SelectAllSignIn")
    public ObjectJson selectAllSignInRecord() throws ParseException {
        SignInRequest[] signRecords = managerService.selectAllSignInRecord();
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(signRecords.length);
        objectJson.setData(signRecords);
        return objectJson;
    }
    @ApiOperation("选择所有请假信息")
    @RequestMapping("/SelectAllStudentQJ")
    public ObjectJson selectAllStudentQj(){
        List<StudentQJ> studentQJS = managerService.selectAllStudentQj();
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
    @ApiOperation("跟据签到信息ID删除签到信息")
    @RequestMapping("/deleteSignInById/{qdid}")
    public ObjectJson deleteSignInById(@PathVariable String qdid){
        managerService.deleteSignInById(Integer.parseInt(qdid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }
    @ApiOperation("跟据请假信息ID删除请假信息")
    @RequestMapping("/deleteStudentQJById/{qjid}")
    public ObjectJson deleteStudentQjById(@PathVariable String qjid){
        System.out.println(qjid);
        managerService.deleteStudentQjById(Integer.parseInt(qjid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    @RequestMapping("/deleteStudentQJsById")
    public ObjectJson deleteStudentQjsById(@RequestParam(value = "qjid") String qjid){
        if (qjid==null||qjid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = qjid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            managerService.deleteStudentQjById(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    @RequestMapping("/deleteSignInsById")
    public ObjectJson deleteSignInsById(@RequestParam(value = "qqdid") String qqdid){
        if (qqdid==null||qqdid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = qqdid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            managerService.deleteSignInById(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }
    @RequestMapping("/deleteStudentsById")
    public ObjectJson deleteStudentsById(@RequestParam(value = "sid") String sid){
        if (sid==null||sid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = sid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            managerService.deleteStudentById(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    @RequestMapping("/deleteCoursesById")
    public ObjectJson deleteCoursesById(@RequestParam(value = "cid") String cid){
        if (cid==null||cid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = cid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            managerService.deleteCourseById(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }
    @RequestMapping("/deleteTeacherById")
    public ObjectJson deleteTeacherById(@RequestParam(value = "tid") String tid){
        if (tid==null||tid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = tid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            managerService.deleteTeacherById(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    @RequestMapping("/deleteCVsById")
    public ObjectJson deleteCVsById(@RequestParam(value = "vid") String vid){
        if (vid==null||vid.equals("[]")){
            ObjectJson objectJson = new ObjectJson();
            objectJson.setCode("200");
            objectJson.setMsg("删除失败，无可删除信息");
            return objectJson;
        }
        String[] split = vid.split("\\[");
        String[] split1 = split[1].split("\\]");
        String[] split2 = split1[0].split(",");
        for (int i = 0; i < split2.length; i++) {
            teacherService.deleteCourseVideoService(Integer.parseInt(split2[i]));
        }

        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }



}
