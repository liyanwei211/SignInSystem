package com.liyanwei.signinsystem.service;

import com.liyanwei.signinsystem.bean.*;
import com.liyanwei.signinsystem.common.SignInRequest;
import com.liyanwei.signinsystem.mapper.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lyw
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseVideoMapper courseVideoMapper;
    @Autowired
    private StudentQJMapper studentQjMapper;
    @Autowired
    private CcourseMapper ccourseMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addStudentService(Student student) {
        studentMapper.addStudent(student);
    }


    /**
     * @param snumber 学生学号
     * @param spassword 登陆密码
     * @return Student 学生信息
     * 学生登陆功能
     */
    @Override
    public Student studentLogin(String snumber,String spassword) {
        Student student = new Student();
        student.setSnumber(snumber);
        student.setSpassword(spassword);
        return studentMapper.selectStuBySnoAndPass(student);
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public String studentSignin(String snumber, Integer setId) {
        Student student = studentMapper.selectStudentBySnumber(snumber);
        String sclass = student.getSclass();
        SignSet signSet = studentMapper.selectSignSetBySetId(setId);
        SignRecord rec = new SignRecord();
        rec.setSnumber(student.getSnumber());
        rec.setSetId(signSet.getId());
        SignRecord record1 = studentMapper.selectSignRecordBySnumAndSetId(rec);
        if (record1!=null){
            return "failed";
        }
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String signInTime = format0.format(date);
        SignRecord record = new SignRecord(student.getSnumber(),signSet.getTnumber(),signSet.getCnumber(),signInTime,signSet.getId());
        studentMapper.studentSignin(record);
        return "success";

    }

    @Override
    public List<CourseVideo> selectAllCourseVideo() {
        List<CourseVideo> videos = courseVideoMapper.selectAllCourseVideo();
        return videos;
    }

    @Override
    public void addStudentQjService(StudentQJ studentQj) {
        studentQjMapper.addStudentQj(studentQj);
    }

    @Override
    public List<StudentQJ> selectStudentQjBySnumService(String snumber) {
        List<StudentQJ> studentQjs = studentQjMapper.selectStudentQjBySnum(snumber);
        return studentQjs;
    }

    @Override
    public List<SignSet> selectSignSetByClass(String sclass) throws ParseException {
        List<SignSet> signSets = studentMapper.selectSignSetByClass(sclass);
        List<SignSet> signSetList = new ArrayList<>();
        for (int i = 0; i < signSets.size(); i++) {
            String classtime = signSets.get(i).getClasstime();
            String[] s = classtime.split(" ");
            String day = s[0];
            String time = s[1];
            String[] split = time.split("-");
            String start = day+" "+split[0];
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String format1 = format.format(date);
            Date format2 = format.parse(day);
            Date format3 = format.parse(format1);
            if(format2.getTime()==format3.getTime()){
                signSetList.add(signSets.get(i));
            }

        }
        return signSetList;
    }

    @Override
    public SignInRequest[] selectSignRecordBySnum(String snumber) throws ParseException {
        List<SignRecord> signRecords = studentMapper.selectSignRecordBySnum(snumber);
        SignInRequest[] signInRequests = new SignInRequest[signRecords.size()];
        Student student = studentMapper.selectStudentBySnumber(snumber);
        for (int i = 0; i < signRecords.size(); i++) {
            SignRecord record = signRecords.get(i);
            String signintime = record.getSignintime();
            Integer setId = record.getSetId();
            SignSet signSet = studentMapper.selectSignSetBySetId(setId);
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
            sign.setSnumber(snumber);
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
    @Override
    public void addStudentCc(String number, String cnumber, String charactor) {
        Ccourse ccourse = new Ccourse(number,cnumber,charactor);
        ccourseMapper.addCcourse(ccourse);
    }

    @Override
    public List<Map> selectStudentCc(String number) {
        List<Ccourse> ccourses = ccourseMapper.selectCcByNum(number);
        List<Map> courses = new ArrayList<>();
        for (Ccourse ccourse: ccourses) {
            String cnumber = ccourse.getCnumber();
            Map course = courseMapper.selectCourseByCnum(cnumber);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Ccourse selectStudentCcByNumAndCnum(String number, String cnumber) {
        Ccourse ccourses = ccourseMapper.selectCcByNumAndCnum(number, cnumber);
        return ccourses;
    }

    @Override
    public void deleteStudentCc(Integer ccid) {
        ccourseMapper.deleteCcById(ccid);
    }

    @Override
    public List<Map> selectAllCourse() {
        List<Map> courses = courseMapper.selectAllCourses();
        return courses;
    }

    @Override
    public void updateStudentById(Student student) {
        studentMapper.updateStudentById(student);
    }
}
