package com.liyanwei.signinsystem.web;

import com.liyanwei.signinsystem.bean.Student;
import com.liyanwei.signinsystem.bean.Teacher;
import com.liyanwei.signinsystem.common.ObjectJson;
import com.liyanwei.signinsystem.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lyw
 */
@Api(tags = "管理员管理用户接口")
@RestController
public class ManageUserController {
    @Autowired
    private ManagerService managerService;

    @ApiOperation("查询全部学生信息")
    @RequestMapping("/SelectAllStudent")
    public ObjectJson selectAllStduents(){
        List<Student> students = managerService.selectAllStudents();
        Student[] stus = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            stus[i] = students.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(stus.length);
        objectJson.setData(stus);
        return objectJson;
    }
    @ApiOperation("查询全部教师信息")
    @RequestMapping("/SelectAllTeacher")
    public ObjectJson selectAllTeachers(){
        List<Teacher> teachers = managerService.selectAllTeachers();
        Teacher[] teachers1 = new Teacher[teachers.size()];
        for (int i = 0; i < teachers.size(); i++) {
            teachers1[i] = teachers.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(teachers.size());
        objectJson.setData(teachers1);
        return objectJson;

    }
    @RequestMapping("/SelectTeacherByTnum/{tnumber}")
    public ObjectJson selectTeacherByTnum(@PathVariable String tnumber){
        Teacher teacher = managerService.selectTeacherByTnum(tnumber);
        Teacher[] teachers = new Teacher[1];
        teachers[0] = teacher;
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(teachers.length);
        objectJson.setData(teachers);
        return objectJson;
    }
    @RequestMapping("/SelectTeacherByTname/{tname}")
    public ObjectJson selectTeacherByTname(@PathVariable String tname){
        List<Teacher> teachers = managerService.selectTeacherByTname(tname);
        Teacher[] teachers1 = new Teacher[teachers.size()];
        for (int i = 0; i < teachers.size(); i++) {
            teachers1[i] = teachers.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(teachers.size());
        objectJson.setData(teachers1);
        return objectJson;
    }
    @RequestMapping("/SelectStudentByFaculty/{sfaculty}")
    public ObjectJson selectStudentByFaculty(@PathVariable String sfaculty){
        List<Student> students = managerService.selectStudentByfaculty(sfaculty);
        Student[] stus = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            stus[i] = students.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(stus.length);
        objectJson.setData(stus);
        return objectJson;
    }
    @RequestMapping("/SelectStudentBySclass/{sclass}")
    public ObjectJson selectStudentBySclass(@PathVariable String sclass){
        List<Student> students = managerService.selectStudentBySclass(sclass);
        Student[] stus = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            stus[i] = students.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(stus.length);
        objectJson.setData(stus);
        return objectJson;
    }
    @RequestMapping("/SelectTeacherByFaculty/{tfaculty}")
    public ObjectJson selectTeacherByFaculty(@PathVariable String tfaculty){
        List<Teacher> teachers = managerService.selectTeacherByFaculty(tfaculty);
       Teacher[] teachs = new Teacher[teachers.size()];
        for (int i = 0; i < teachers.size(); i++) {
            teachs[i] = teachers.get(i);
        }
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("success");
        objectJson.setCount(teachs.length);
        objectJson.setData(teachs);
        return objectJson;
    }




    @ApiOperation("根据ID删除学生信息")
    @RequestMapping("/deleteStudent/{sid}")
    public ObjectJson deleteStudent(@PathVariable String sid){
        managerService.deleteStudentById(Integer.parseInt(sid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }

    @ApiOperation("根据ID删除教师信息")
    @RequestMapping("/deleteTeacher/{tid}")
    public ObjectJson deleteTeacher(@PathVariable String tid){
        managerService.deleteTeacherById(Integer.parseInt(tid));
        ObjectJson objectJson = new ObjectJson();
        objectJson.setCode("200");
        objectJson.setMsg("删除成功");
        return objectJson;
    }




}
