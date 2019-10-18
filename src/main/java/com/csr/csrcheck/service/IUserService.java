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
}
