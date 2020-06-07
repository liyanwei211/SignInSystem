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
 * @author lyw
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentQJMapper studentQjMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseVideoMapper courseVideoMapper;


    @Override
    public void addManagerService(Manager manager) {
        managerMapper.addManager(manager);
    }

    @Override
    public Manager managerLogin(String mnumber, String mpassword) {
        Manager manager = managerMapper.selectManagerByNumAndPass(mnumber, mpassword);
        return manager;
    }

    @Override
    public Student selectStudentBySnum(String snumber) {
        Student student = studentMapper.selectStudentBySnumber(snumber);
        return student;
    }

    @Override
    public List<Student> selectStudentBySname(String sname) {
        List<Student> students = studentMapper.selectStudentBySname(sname);
        return students;
    }

    @Override
    public List<Student> selectStudentByfaculty(String sfaculty) {
        List<Student> students = studentMapper.selectStudentsByFaculty(sfaculty);
        return students;
    }

    @Override
    public List<Student> selectStudentBySclass(String sclass) {
        List<Student> students = studentMapper.selectStudentsBySclass(sclass);
        return students;
    }

    @Override
    public List<Teacher> selectTeacherByFaculty(String tfaculty) {
        List<Teacher> teachers = teacherMapper.selectTeacherByFaculty(tfaculty);
        return teachers;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = studentMapper.selectAllStudents();
        return students;
    }

    @Override
    public Teacher selectTeacherByTnum(String tnumber) {
        Teacher teacher = teacherMapper.selectTeacherByTnum(tnumber);
        return teacher;
    }

    @Override
    public List<Teacher> selectTeacherByTname(String tname) {
        List<Teacher> teachers = teacherMapper.selectTeacherByTname(tname);
        return teachers;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        List<Teacher> teachers = teacherMapper.selectAllTeachers();
        return teachers;
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
    public List<Map> selectAllCourse() {
        List<Map> courses = courseMapper.selectAllCourses();
        return courses;
    }

    @Override
    public SignInRequest[] selectAllSignInRecord() throws ParseException {
        List<SignRecord> signRecords = managerMapper.selectSignInRecord();
        SignInRequest[] signInRequests = new SignInRequest[signRecords.size()];
        for (int i = 0; i < signRecords.size(); i++) {
            Student student = studentMapper.selectStudentBySnumber(signRecords.get(i).getSnumber());
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
            sign.setQdid(Integer.parseInt(record.getQdid().toString()));
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

    @Override
    public List<StudentQJ> selectAllStudentQj() {
        List<StudentQJ> studentQJS = studentQjMapper.selectAllStudentQjs();
        return studentQJS;
    }

    @Override
    public List<CourseVideo> selectAllCv() {
        List<CourseVideo> courseVideos = courseVideoMapper.selectAllCourseVideo();
        return courseVideos;
    }

    @Override
    public void addStduent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteStudentById(Integer sid) {
        studentMapper.deleteStudentById(sid);
    }

    @Override
    public void deleteTeacherById(Integer tid) {
        teacherMapper.deleteTeacherById(tid);
    }

    @Override
    public void deleteCourseById(Integer cid) {
        courseMapper.deleteCourseById(cid);
    }

    @Override
    public void deleteSignInById(Integer qdid) {
        SignRecord record = managerMapper.selectSignInRecordById(qdid);
        Integer setId = record.getSetId();
        managerMapper.deleteSignRecordById(qdid);
    }

    @Override
    public void deleteStudentQjById(Integer qjid) {
        studentQjMapper.deleteStudentQjById(qjid);
    }

    @Override
    public void managerUpdateCourse(Course course) {
        courseMapper.updateCourseById(course);
    }


}
