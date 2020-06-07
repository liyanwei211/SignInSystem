package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;


/**
 * 管理员类
 * @author liyanwei
 */
@Entity
@Table(name = "managers")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component

public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Integer mid;
    @Column(name = "m_number")
    private String mnumber;
    @Column(name = "m_name")
    private String mname;
    @Column(name = "m_password")
    private String mpassword;
    @Column(name = "m_gender")
    private String mgender;
    @Column(name = "m_birthday")
    private String mbirthday;
    @Column(name = "m_idcard")
    private String midcard;
    @Column(name = "m_phone")
    private String mphone;
    @Column(name = "m_email")
    private String memail;

    public Manager() {
    }

    public Manager(String mnumber, String mname, String mpassword, String mgender, String mbirthday, String midcard, String mphone, String memail) {
        this.mnumber = mnumber;
        this.mname = mname;
        this.mpassword = mpassword;
        this.mgender = mgender;
        this.mbirthday = mbirthday;
        this.midcard = midcard;
        this.mphone = mphone;
        this.memail = memail;
    }

    public Manager(Integer mid, String mnumber, String mname, String mgender, String mbirthday, String midcard, String mphone, String memail) {
        this.mid = mid;
        this.mnumber = mnumber;
        this.mname = mname;
        this.mgender = mgender;
        this.mbirthday = mbirthday;
        this.midcard = midcard;
        this.mphone = mphone;
        this.memail = memail;
    }

    public Manager(Integer mid, String mnumber, String mname, String mpassword, String mgender, String mbirthday, String midcard, String mphone, String memail) {
        this.mid = mid;
        this.mnumber = mnumber;
        this.mname = mname;
        this.mpassword = mpassword;
        this.mgender = mgender;
        this.mbirthday = mbirthday;
        this.midcard = midcard;
        this.mphone = mphone;
        this.memail = memail;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMnumber() {
        return mnumber;
    }

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMgender() {
        return mgender;
    }

    public void setMgender(String mgender) {
        this.mgender = mgender;
    }

    public String getMbirthday() {
        return mbirthday;
    }

    public void setMbirthday(String mbirthday) {
        this.mbirthday = mbirthday;
    }

    public String getMidcard() {
        return midcard;
    }

    public void setMidcard(String midcard) {
        this.midcard = midcard;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", mnumber='" + mnumber + '\'' +
                ", mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                ", mgender='" + mgender + '\'' +
                ", mbirthday='" + mbirthday + '\'' +
                ", midcard='" + midcard + '\'' +
                ", mphone='" + mphone + '\'' +
                ", memail='" + memail + '\'' +
                '}';
    }
}
