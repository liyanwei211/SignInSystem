package com.liyanwei.signinsystem.common;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.Serializable;
import java.lang.reflect.Array;

public class ObjectJson implements Serializable {
    private static final long serialVersionUID = -8070370672219299798L;
    private String code;
    private String msg;
    private int count;
    private Object[] data;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
