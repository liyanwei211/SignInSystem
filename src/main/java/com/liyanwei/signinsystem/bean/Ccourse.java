package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ccourses")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component
public class Ccourse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cc_id")
    private Integer ccid;
    @Column(name = "number")
    private String number;
    @Column(name = "c_number")
    private String cnumber;
    @Column(name = "charactor")
    private String charactor;

    public Ccourse() {
    }

    public Ccourse(String number, String cnumber, String charachor) {
        this.number = number;
        this.cnumber = cnumber;
        this.charactor = charachor;
    }

    public Ccourse(Integer ccid, String number, String cnumber, String charachor) {
        this.ccid = ccid;
        this.number = number;
        this.cnumber = cnumber;
        this.charactor = charachor;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCharactor() {
        return charactor;
    }

    public void setCharactor(String charactor) {
        this.charactor = charactor;
    }

    @Override
    public String toString() {
        return "Ccourse{" +
                "ccid=" + ccid +
                ", number='" + number + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", charachor='" + charactor + '\'' +
                '}';
    }
}
