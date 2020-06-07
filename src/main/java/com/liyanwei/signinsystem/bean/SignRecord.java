package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lyw
 * 学生签到记录的POJO类
 */
@Entity
@Table(name = "signinrecord")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component
public class SignRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qd_id")
    private Integer qdid;
    @Column(name = "s_number")
    private String snumber;
    @Column(name = "t_number")
    private String tnumber;
    @Column(name = "c_number")
    private String cnumber;
    @Column(name = "signintime")
    private String signintime;
    @Column(name = "set_id")
    private Integer setId;

    public SignRecord() {
    }

    public SignRecord(String snumber, String tnumber, String cnumber, String signintime,Integer setId) {
        this.snumber = snumber;
        this.tnumber = tnumber;
        this.cnumber = cnumber;
        this.signintime = signintime;
        this.setId = setId;
    }

    public SignRecord(Integer qdid, String snumber, String tnumber, String cnumber, String signintime, Integer setId) {
        this.qdid = qdid;
        this.snumber = snumber;
        this.tnumber = tnumber;
        this.cnumber = cnumber;
        this.signintime = signintime;
        this.setId = setId;
    }

    public Integer getQdid() {
        return qdid;
    }

    public void setQdid(Integer qdid) {
        this.qdid = qdid;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    @Override
    public String toString() {
        return "SignRecord{" +
                "qdid=" + qdid +
                ", snumber='" + snumber + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", signintime='" + signintime + '\'' +
                '}';
    }
}
