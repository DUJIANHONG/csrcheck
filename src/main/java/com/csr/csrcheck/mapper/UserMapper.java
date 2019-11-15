package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/14 16:24
 * @version:
 * @modified By:
 */
public interface UserMapper {
    /**
     * 通过用户名查询用户数据
     * @param user_name
     * @return
     */
    User findUser_name(String user_name);

    /**
     * 修改密码
     * @param newpassworld  新密码
     * @return
     */
    Integer UpdatePassword(int user_id,String newpassworld);

    /**
     * 通过user_id查询用户数据
     * @param user_id
     * @return
     */
    User findUser(int user_id);

    /**
     *根据user_id修改用户信息
     *  @param user_id
     * @param user_name
     * @param user_sex
     * @param user_age
     * @param user_address
     * @return
     */
    Integer UpdateUser(int user_id,String user_name,int user_sex,int user_age,String user_address);

    /**
     * 根据用户id修改用户头像
     * @param user_photo
     * @return
     */
    Integer UpdatePhoto(String user_photo,int user_id);

}
