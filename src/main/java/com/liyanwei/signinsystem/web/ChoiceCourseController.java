package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Ccourse;
import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.CourseRequest;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.StudentService;
import com.liyanwei.signinsystem.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Api(tags = "选课管理接口")
@RestController
public class ChoiceCourseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    /**
     * 添加学生选课信息
     *
     *
     */
    @ResponseBody
    @RequestMapping("/html/AddStudentCc")
    public ObjectJson addStudentCc(HttpServletRequest request, HttpServletResponse response ){
        Student student = (Student) request.getSession().getAttribute("student");
        String cnumber = request.getParameter("cnumber");
        String chararctor = "学生";
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        Ccourse ccourse = studentService.selectStudentCcByNumAndCnum(student.getSnumber(), cnumber);
        if (ccourse!=null){
            objectJson.setMsg("已选择此课程，请勿请勿重复选取");
            return objectJson;
        }
        studentService.addStudentCc(student.getSnumber(),cnumber,chararctor);
        objectJson.setCode("200");
        objectJson.setMsg("选课成功");
        return objectJson;
    }

    /**
     * 通过学号查询选课信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/html/SelectStudentCc")
    public ObjectJson selectStudentCc(HttpServletRequest request, HttpServletResponse response){

        Student student = (Student) request.getSession().getAttribute("student");
        String snumber = student.getSnumber();
        List<Map> courses = studentService.selectStudentCc(snumber);
        ObjectJson objectJson = new ObjectJson();
        CourseRequest[] data = new CourseRequest[courses.size()];
        for (int i=0;i<courses.size();i++) {
            CourseRequest courseRequest = new CourseRequest();
            courseRequest.setCid(Integer.parseInt(courses.get(i).get("c_id").toString()));
            courseRequest.setCnumber(courses.get(i).get("c_number").toString());
            courseRequest.setCname(courses.get(i).get("c_name").toString());
            courseRequest.setCtime(courses.get(i).get("c_time").toString());
            data[i] = courseRequest;
        }

        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(courses.size());
        objectJson.setData(data);
        return objectJson;
    }

    /**
     * 通过ccid删除学生选课信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/html/DeleteStudentCc")
    public ObjectJson deleteStudentCc(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        String cnumber = request.getParameter("cnumber");
        Ccourse ccourses = studentService.selectStudentCcByNumAndCnum(student.getSnumber(), cnumber);
        studentService.deleteStudentCc(ccourses.getCcid());
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    /**
     * 添加教师选课信息
     *
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/html/AddTeacherCc")
    public ObjectJson addTeacherCc(HttpServletRequest request ){
        String cnumber = request.getParameter("cnumber");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String chararctor = "教师";
        Ccourse ccourse = studentService.selectStudentCcByNumAndCnum(teacher.getTnumber(), cnumber);
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        if (ccourse!=null){
            objectJson.setMsg("已选择该课程，请勿重复选择");
            return objectJson;
        }
        teacherService.addTeacherCc(teacher.getTnumber(),cnumber,chararctor);
        objectJson.setMsg("选课成功");
        return objectJson;
    }

    /**
     * 通过工号查询教师选课信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/html/SelectTeacherCc")
    public ObjectJson selectTeacherCc(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        List<Ccourse> ccourses = teacherService.selectTeacherCc(teacher.getTnumber());
        CourseRequest[] data = new CourseRequest[ccourses.size()];
        for (int i = 0; i < ccourses.size(); i++) {
            String cnumber = ccourses.get(i).getCnumber();
            Map courses = teacherService.selectCourseByCnum(cnumber);
            CourseRequest courseRequest = new CourseRequest();
            courseRequest.setCid(Integer.parseInt(courses.get("c_id").toString()));
            courseRequest.setCnumber(courses.get("c_number").toString());
            courseRequest.setCname(courses.get("c_name").toString());
            courseRequest.setCtime(courses.get("c_time").toString());
            data[i] = courseRequest;

        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(data.length);
        objectJson.setData(data);
        return objectJson;

    }

    /**
     * 通过ccid删除选课信息
     * @return

     */
    @ResponseBody
    @RequestMapping("/html/DeleteTeacherCc")
    public ObjectJson deleteTeacherCc(HttpServletRequest request){
        String cnumber = request.getParameter("cnumber");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        Ccourse ccourse = studentService.selectStudentCcByNumAndCnum(teacher.getTnumber(), cnumber);
        teacherService.deleteTeacherCc(ccourse.getCcid());
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }



}
