package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.Ccourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcourseMapper {

    /**
     * 添加选课信息
     * @param ccourse 选课信息
     */
    void addCcourse(Ccourse ccourse);

    /**
     * 根据学号或工号查询选课信息
     * @param number 学号或工号
     * @return List<Ccourse> 查询到的选课信息的集合
     */
    List<Ccourse> selectCcByNum(String number);

    /**
     * @param number
     * @param cnumber
     * @return
     */
    Ccourse selectCcByNumAndCnum(String number,String cnumber);

    void deleteCcById(Integer ccid);


}
