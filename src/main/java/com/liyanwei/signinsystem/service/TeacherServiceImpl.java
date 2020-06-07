package com.liyanwei.signinsystem.service;

import com.liyanwei.signinsystem.bean.*;
import com.liyanwei.signinsystem.common.SignInRequest;
import com.liyanwei.signinsystem.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 教师的Service层
 * @author lyw
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseVideoMapper courseVideoMapper;
    @Autowired
    private StudentQJMapper studentQjMapper;
    @Autowired
    private CcourseMapper ccourseMapper;


    @Override
    public void addTeacherService(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher teacherLogin(String tnumber, String tpassword) {

        Teacher teacher = teacherMapper.selectTeacherByNumAndPass(tnumber,tpassword);
        return teacher;

    }

    @Override
    public String addSignIn(String cname, String tnumber, String classtime, String classnumber, int pnumber) {
        Course course = courseMapper.selectCourseByName(cname);
        SignSet signSet1 = studentMapper.selectSignSetByCtname(course.getCnumber(), tnumber, classtime);
        if (signSet1!=null){
            String s = "添加失败，签到设置已存在";
            return s;
        }
        SignSet signSet = new SignSet(course.getCnumber(),tnumber,classtime,classnumber);
        teacherMapper.addSignIn(signSet);
        return "添加成功";
    }


    @Override
    public void addCourseVideoService(String cname, String tname, String coursetime, String vvideo) {
        Teacher teacher = teacherMapper.selectTeacherByName(tname);
        Course course = courseMapper.selectCourseByName(cname);
        CourseVideo video = new CourseVideo(course.getCnumber(),teacher.getTnumber(),coursetime,vvideo);
        courseVideoMapper.addCourseVideo(video);
    }

    @Override
    public void deleteCourseVideoService(Integer vid) {
        courseVideoMapper.deleteVideoById(vid);
    }

    @Override
    public void updateStudentQjService(String qjid, String qjstatus) {
        StudentQJ qj = new StudentQJ();
        qj.setQjid(Integer.parseInt(qjid));
        qj.setQjstatus(qjstatus);
        studentQjMapper.updateStudentQjById(qj);
    }

    @Override
    public Student selectStudentBySnumService(String snumber) {
        Student student = studentMapper.selectStudentBySnumber(snumber);
        return student;
    }

    @Override
    public List<Student> selectStudentBySnameService(String sname) {
        List<Student> students = studentMapper.selectStudentBySname(sname);
        return students;
    }

    @Override
    public Map selectCourseByCnum(String cnumber) {
        Map course = courseMapper.selectCourseByCnum(cnumber);
        return course;
    }

    @Override
    public Course selectCourseByCname(String cname) {
        Course course = courseMapper.selectCourseByName(cname);
        return course;
    }

    @Override
    public StudentQJ[] selectStudentQjBySname(String sname) {
        List<StudentQJ> studentQJS = studentQjMapper.selectStudentQjBySname(sname);
        StudentQJ[] qjs = new StudentQJ[studentQJS.size()];
        for (int i = 0; i < studentQJS.size(); i++) {
            qjs[i] = studentQJS.get(i);
        }
        return qjs;
    }

    @Override
    public StudentQJ[] selectAllStudentQj() {
        List<StudentQJ> studentQJS = studentQjMapper.selectAllStudentQjs();
        StudentQJ[] qjs = new StudentQJ[studentQJS.size()];
        for (int i = 0; i < studentQJS.size(); i++) {
            qjs[i] = studentQJS.get(i);
        }
        return qjs;
    }

    @Override
    public void addTeacherCc(String number, String cnumber, String charactor) {
        Ccourse ccourse = new Ccourse(number,cnumber,charactor);
        ccourseMapper.addCcourse(ccourse);
    }

    @Override
    public List<Ccourse> selectTeacherCc(String number) {
        List<Ccourse> ccourses = ccourseMapper.selectCcByNum(number);
        return ccourses;
    }

    @Override
    public void deleteTeacherCc(Integer ccid) {
        ccourseMapper.deleteCcById(ccid);
    }

    @Override
    public void updateTeacherById(Teacher teacher) {
        teacherMapper.updateTeacherById(teacher);
    }

    @Override
    public SignInRequest[] selectSignRecordForTeacher(String cname, String tnubmer, String classtime) throws ParseException {
        Course course = courseMapper.selectCourseByName(cname);
        SignSet signSet = studentMapper.selectSignSetByCtname(course.getCnumber(), tnubmer, classtime);
        List<SignRecord> signRecords = studentMapper.selectSignRecordBySetId(signSet.getId());
        SignInRequest[] signInRequests = new SignInRequest[signRecords.size()];
        for (int i = 0; i < signRecords.size(); i++) {
            Student student = studentMapper.selectStudentBySnumber(signRecords.get(i).getSnumber());
            SignRecord record = signRecords.get(i);
            String signintime = record.getSignintime();
            String[] s = signSet.getClasstime().split(" - ");
            String start = s[0];
            String end = s[1];
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date starttime = format.parse(start);
            Date endtime = format.parse(end);
            Date signtime = format.parse(signintime);
            String status = null;
            if (starttime.getTime() <= signtime.getTime()&&signtime.getTime()<=endtime.getTime()){
                status = "已签到";
            }else {
                status = "旷课";
            }
            SignInRequest sign = new SignInRequest();
            sign.setQdid(record.getQdid());
            sign.setSnumber(student.getSnumber());
            sign.setSname(student.getSname());
            Map map = courseMapper.selectCourseByCnum(signRecords.get(i).getCnumber());
            sign.setCname(map.get("c_name").toString());
            sign.setSclass(student.getSclass());
            sign.setClasstime(signSet.getClasstime());
            sign.setStutus(status);
            signInRequests[i] = sign;
        }

        return signInRequests;
    }


}
