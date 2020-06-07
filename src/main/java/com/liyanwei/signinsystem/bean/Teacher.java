package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lyw
 */
@Entity
@Table(name = "teachers")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component
public class Teacher implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer tid;
    @Column(name = "t_number")
    private String tnumber;
    @Column(name = "t_name")
    private String tname;
    @Column(name = "t_password")
    private String tpassword;
    @Column(name = "t_gender")
    private String tgender;
    @Column(name = "t_birthday")
    private String tbirthday;
    @Column(name = "t_idcard")
    private String tidcard;
    @Column(name = "t_faculty")
    private String tfaculty;
    @Column(name = "t_phone")
    private String tphone;
    @Column(name = "t_email")
    private String temail;

    public Teacher() {
    }

    public Teacher(String tnumber, String tname, String tpassword, String tgender, String tbirthday, String tidcard, String tfaculty, String tphone, String temail) {
        this.tnumber = tnumber;
        this.tname = tname;
        this.tpassword = tpassword;
        this.tgender = tgender;
        this.tbirthday = tbirthday;
        this.tidcard = tidcard;
        this.tfaculty = tfaculty;
        this.tphone = tphone;
        this.temail = temail;
    }

    public Teacher(Integer tid, String tnumber, String tname, String tgender, String tbirthday, String tidcard, String tfaculty, String tphone, String temail) {
        this.tid = tid;
        this.tnumber = tnumber;
        this.tname = tname;
        this.tgender = tgender;
        this.tbirthday = tbirthday;
        this.tidcard = tidcard;
        this.tfaculty = tfaculty;
        this.tphone = tphone;
        this.temail = temail;
    }

    public Teacher(Integer tid, String tnumber, String tname, String tpassword, String tgender, String tbirthday, String tidcard, String tfaculty, String tphone, String temail) {
        this.tid = tid;
        this.tnumber = tnumber;
        this.tname = tname;
        this.tpassword = tpassword;
        this.tgender = tgender;
        this.tbirthday = tbirthday;
        this.tidcard = tidcard;
        this.tfaculty = tfaculty;
        this.tphone = tphone;
        this.temail = temail;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public String getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(String tbirthday) {
        this.tbirthday = tbirthday;
    }

    public String getTidcard() {
        return tidcard;
    }

    public void setTidcard(String tidcard) {
        this.tidcard = tidcard;
    }

    public String getTfaculty() {
        return tfaculty;
    }

    public void setTfaculty(String tfaculty) {
        this.tfaculty = tfaculty;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tgender='" + tgender + '\'' +
                ", tbirthday=" + tbirthday +
                ", tidcard='" + tidcard + '\'' +
                ", tfaculty='" + tfaculty + '\'' +
                ", tphone='" + tphone + '\'' +
                ", temail='" + temail + '\'' +
                '}';
    }
}
