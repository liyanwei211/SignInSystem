package com.liyanwei.signinsystem.common;

import javax.persistence.Column;
import java.io.Serializable;

public class CcourseRequest implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private Integer ccid;
    private String number;
    private String cnumber;
    private String charachor;

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

    public String getCharachor() {
        return charachor;
    }

    public void setCharachor(String charachor) {
        this.charachor = charachor;
    }
}
