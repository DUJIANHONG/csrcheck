package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.User;

public interface IUserService {
    /**
     * 登录
     * @param user_name
     * @param password
     * @return
     */
    User login(String user_name, String password);

    /**
     * 修改密码
     * @param user_id
     * @param oldpassword  原密码
     * @param newpassworld 新密码
     * @return
     */
    public void UpdatePassword(int user_id,String oldpassword,String newpassworld);

    /**
     *根据user_id查找用户数据
     *  @param user_id
     * @return
     */
    User finduser(int user_id);
}
