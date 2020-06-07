package com.liyanwei.signinsystem.bean;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author liyanwei
 */
@Component
@Entity
@Table(name = "students")

public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer sid;
    @Column(name = "s_number")
    private String snumber;
    @Column(name = "s_name")
    private String sname;
    @Column(name = "s_password")
    private String spassword;
    @Column(name = "s_gender")
    private String sgender;
    @Column(name = "s_birthday")
    private String sbirthday;
    @Column(name = "s_idcard")
    private String sidcard;
    @Column(name = "s_faculty")
    private String sfaculty;
    @Column(name = "s_class")
    private String sclass;
    @Column(name = "s_phone")
    private String sphone;
    @Column(name = "s_email")
    private String semail;

    public Student() {
    }



    public Student(Integer sid, String sname, String sgender, String sbirthday, String sidcard, String sfaculty, String sclass, String sphone, String semail) {
        this.sid = sid;
        this.sname = sname;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.sidcard = sidcard;
        this.sfaculty = sfaculty;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
    }

    public Student(String snumber, String sname, String spassword, String sgender, String sbirthday, String sidcard, String sfaculty, String sclass, String sphone, String semail) {
        this.snumber = snumber;
        this.sname = sname;
        this.spassword = spassword;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.sidcard = sidcard;
        this.sfaculty = sfaculty;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
    }

    public Student(String sname, String spassword, String sgender, String sbirthday, String sidcard, String sfaculty, String sclass, String sphone, String semail) {

        this.sname = sname;
        this.spassword = spassword;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.sidcard = sidcard;
        this.sfaculty = sfaculty;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
    }
    public Student(Integer sid, String sname, String spassword, String sgender, String sbirthday, String sidcard, String sfaculty, String sclass, String sphone, String semail) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.sidcard = sidcard;
        this.sfaculty = sfaculty;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
    }

    public Student(Integer sid, String snumber, String sname, String spassword, String sgender, String sbirthday, String sidcard, String sfaculty, String sclass, String sphone, String semail) {
        this.sid = sid;
        this.snumber = snumber;
        this.sname = sname;
        this.spassword = spassword;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.sidcard = sidcard;
        this.sfaculty = sfaculty;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSidcard() {
        return sidcard;
    }

    public void setSidcard(String sidcard) {
        this.sidcard = sidcard;
    }

    public String getSfaculty() {
        return sfaculty;
    }

    public void setSfaculty(String sfaculty) {
        this.sfaculty = sfaculty;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sbirthday=" + sbirthday +
                ", sidcard='" + sidcard + '\'' +
                ", sfaculty='" + sfaculty + '\'' +
                ", sclass='" + sclass + '\'' +
                ", sphone='" + sphone + '\'' +
                ", semail='" + semail + '\'' +
                '}';
    }
}
