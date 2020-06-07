package com.liyanwei.signinsystem.common;

import java.io.Serializable;

public class SignInRequest implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private Integer qdid;
    private String snumber;
    private String sname;
    private String sclass;
    private String cname;
    private String classtime;
    private String stutus;

    public String getSnumber() {
        return snumber;
    }

    public Integer getQdid() {
        return qdid;
    }

    public void setQdid(Integer qdid) {
        this.qdid = qdid;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getStutus() {
        return stutus;
    }

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }
}
