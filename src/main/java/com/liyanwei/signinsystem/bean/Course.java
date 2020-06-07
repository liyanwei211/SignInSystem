package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 课程类
 * @author liyanwei
 */
@Entity
@Table(name = "courses")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component

public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer cid;
    @Column(name = "c_number")
    private String cnumber;
    @Column(name = "c_name")
    private String cname;
    @Column(name = "c_time")
    private String ctime;

    public Course() {
    }

    public Course(String cnumber, String cname, String ctime) {
        this.cnumber = cnumber;
        this.cname = cname;
        this.ctime = ctime;
    }

    public Course(Integer cid, String cnumber, String cname, String ctime) {
        this.cid = cid;
        this.cnumber = cnumber;
        this.cname = cname;
        this.ctime = ctime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cnumber='" + cnumber + '\'' +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
