package com.liyanwei.signinsystem.common;

import java.io.Serializable;

public class CourseRequest implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private Integer cid;
    private String cnumber;
    private String cname;
    private String ctime;


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
        return "CourseRequest{" +
                "cid='" + cid + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
