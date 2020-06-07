package com.liyanwei.signinsystem.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 课程视频类
 * @author liyanwei
 */
@Entity
@Table(name = "coursevideo")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Component

public class CourseVideo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "v_id")
    private Integer vid;
    @Column(name = "c_number")
    private String cnumber;
    @Column(name = "t_number")
    private String tnumber;
    @Column(name = "coursetime")
    private String coursetime;
    @Column(name = "v_video")
    private String vvideo;

    public CourseVideo() {
    }

    public CourseVideo(String cnumber, String tnumber, String coursetime, String vvideo) {
        this.cnumber = cnumber;
        this.tnumber = tnumber;
        this.coursetime = coursetime;
        this.vvideo = vvideo;
    }

    public CourseVideo(Integer vid, String cnumber, String tnumber, String coursetime, String vvideo) {
        this.vid = vid;
        this.cnumber = cnumber;
        this.tnumber = tnumber;
        this.coursetime = coursetime;
        this.vvideo = vvideo;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
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

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getVvideo() {
        return vvideo;
    }

    public void setVvideo(String vvideo) {
        this.vvideo = vvideo;
    }

    @Override
    public String toString() {
        return "CourseVideo{" +
                "vid=" + vid +
                ", cnumber='" + cnumber + '\'' +
                ", tnumber='" + tnumber + '\'' +
                ", coursetime='" + coursetime + '\'' +
                ", vvideo=" + vvideo +
                '}';
    }
}
