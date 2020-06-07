package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "setsignin")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component

public class SignSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "c_number")
    private String cnumber;
    @Column(name = "t_number")
    private String tnumber;
    @Column(name = "classtime")
    private String classtime;
    @Column(name = "class")
    private String classnumber;

    public SignSet() {
    }
    public SignSet(String cnumber, String tnumber, String classtime, String classnumber) {

        this.cnumber = cnumber;
        this.tnumber = tnumber;
        this.classtime = classtime;
        this.classnumber = classnumber;
    }

    public SignSet(Integer id, String cnumber, String tnumber, String classtime, String classnumber) {
        this.id = id;
        this.cnumber = cnumber;
        this.tnumber = tnumber;
        this.classtime = classtime;
        this.classnumber = classnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    @Override
    public String toString() {
        return "SignSet{" +
                "id=" + id +
                ", cnumber='" + cnumber + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", classtime='" + classtime + '\'' +
                ", classnumber='" + classnumber + '\'' +
                '}';
    }
}
