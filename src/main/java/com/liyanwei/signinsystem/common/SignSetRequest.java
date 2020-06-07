package com.liyanwei.signinsystem.common;

import java.io.Serializable;

public class SignSetRequest implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private String setId;
    private String cname;
    private String tname;
    private String classtime;

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }
}
