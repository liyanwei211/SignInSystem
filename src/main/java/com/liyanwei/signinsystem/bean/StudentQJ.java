package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studentqj")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component

public class StudentQJ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qj_id")
    private Integer qjid;
    @Column(name = "s_number")
    private String snumber;
    @Column(name = "s_name")
    private String sname;
    @Column(name = "s_class")
    private String sclass;
    @Column(name = "qj_time")
    private String qjtime;
    @Column(name = "qj_reason")
    private String qjreason;
    @Column(name = "qj_status")
    private String qjstatus;

    public StudentQJ() {
    }

    public StudentQJ(String snumber, String sname, String sclass, String qjtime, String qjreason, String qjstatus) {
        this.snumber = snumber;
        this.sname = sname;
        this.sclass = sclass;
        this.qjtime = qjtime;
        this.qjreason = qjreason;
        this.qjstatus = qjstatus;
    }

    public StudentQJ(Integer qjid, String snumber, String sname, String sclass, String qjtime, String qjreason, String qjstatus) {
        this.qjid = qjid;
        this.snumber = snumber;
        this.sname = sname;
        this.sclass = sclass;
        this.qjtime = qjtime;
        this.qjreason = qjreason;
        this.qjstatus = qjstatus;
    }

    public Integer getQjid() {
        return qjid;
    }

    public void setQjid(Integer qjid) {
        this.qjid = qjid;
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

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getQjtime() {
        return qjtime;
    }

    public void setQjtime(String qjtime) {
        this.qjtime = qjtime;
    }

    public String getQjreason() {
        return qjreason;
    }

    public void setQjreason(String qjreason) {
        this.qjreason = qjreason;
    }

    public String getQjstatus() {
        return qjstatus;
    }

    public void setQjstatus(String qjstatus) {
        this.qjstatus = qjstatus;
    }

    @Override
    public String toString() {
        return "StudentQJ{" +
                "qjid=" + qjid +
                ", snumber='" + snumber + '\'' +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", qjtime='" + qjtime + '\'' +
                ", qjreason='" + qjreason + '\'' +
                ", qjstatus='" + qjstatus + '\'' +
                '}';
    }
}

