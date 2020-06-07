package com.liyanwei.signinsystem.common;

import java.io.Serializable;

public class QjRequest implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private String snumber;
    private String sname;
    private String sclass;
    private String qjtime;
    private String qjreason;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
