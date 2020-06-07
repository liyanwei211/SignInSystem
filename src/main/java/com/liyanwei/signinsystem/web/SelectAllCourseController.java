package com.liyanwei.signinsystem.web;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.liyanwei.signinsystem.bean.Course;
import com.liyanwei.signinsystem.common.CourseRequest;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lyw
 */
@RestController
public class SelectAllCourseController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/html/SelectAllCourse")
    public ObjectJson selectAllCourse(HttpServletRequest request, HttpServletResponse response){
        List<Map> courses = studentService.selectAllCourse();
        ObjectJson objectJson = new ObjectJson();
        CourseRequest[] data = new CourseRequest[courses.size()];
        if(!courses.isEmpty()){
            for(int i = 0 ; i < courses.size() ; i++){
                CourseRequest courseRequest = new CourseRequest();
                courseRequest.setCid(Integer.parseInt(courses.get(i).get("c_id").toString()));
                courseRequest.setCname(courses.get(i).get("c_name").toString());
                courseRequest.setCnumber(courses.get(i).get("c_number").toString());
                courseRequest.setCtime(courses.get(i).get("c_time").toString());
                data[i] = courseRequest;
            }
        }
        objectJson.setCode("200");
        objectJson.setMsg("");
        objectJson.setCount(courses.size());
        objectJson.setData(data);
        return objectJson;

    }
}
