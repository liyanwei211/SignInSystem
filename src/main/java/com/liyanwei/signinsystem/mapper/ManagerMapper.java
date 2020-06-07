package com.liyanwei.signinsystem.mapper;

import com.liyanwei.signinsystem.bean.*;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author lyw
 */
@Repository
public interface ManagerMapper {
    /**
     * 添加管理员信息
     * @param manager 管理员对象
     */
    public void addManager(Manager manager);

    /**
     * 查询全部的管理员信息
     * @return List<Manager> 返回管理员信息
     */
    public List<Manager> selectAllManagers();

    /**
     * 通过用户名和密码查询管理员用户
     * @param mname 管理员用户名
     * @param mpassword 管理员密码
     * @return Manager 返回管理员对象
     */
    public Manager selectManager(String mname,String mpassword);

    /**
     * 通过管理员工号和密码查询管理员信息
     * @param mnumber 管理员工号
     * @param mpassword 管理员密码
     * @return Manager 返回管理员对象
     */
    Manager selectManagerByNumAndPass(String mnumber,String mpassword);

    /**
     * 查询所有签到信息
     * @return List<SignRecord> 查询到的签到信息
     */
    List<SignRecord> selectSignInRecord();

    /**
     * 根据签到信息ID查询签到信息
     * @param qdid 签到信息ID
     * @return SignRecord 查询到的签到信息
     */
    SignRecord selectSignInRecordById(Integer qdid);



    /**
     * 通过管理员ID修改管理员信息
     * @param manager 管理员对象
     */
    void updateManagerById(Manager manager);

    /**
     * 通过管理员ID删除管理员信息
     * @param mid 管理员ID
     */
    void deleteManagerById(Integer mid);

    /**
     * 通过ID删除设置签到信息
     * @param setId 设置签到的ID
     */
    void deleteSignSetById(Integer setId);

    /**
     * 通过签到信息ID删除签到信息
     * @param qdid 签到信息ID
     */
    void deleteSignRecordById(Integer qdid);

}
