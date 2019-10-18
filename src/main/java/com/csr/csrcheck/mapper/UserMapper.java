package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.User;

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
}
