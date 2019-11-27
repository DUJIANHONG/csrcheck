package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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


    /**
     * 根据user_id修改用户信息
     * @param user_id
     * @param user_name
     * @param user_sex
     * @param user_age
     * @param user_address
     */
    public void UpdateUser(int user_id,String user_name,int user_sex,int user_age,String user_address);

    /**
     * 修改图片
     * @param user_id
     * @param
     * @param request
     */
   void UpdateUser_photo(int user_id, HttpServletRequest request, HttpSession session, MultipartFile file);

    /**
     * 增加管理员
     * @param
     */
   void  addUser(String user_name, String password, int   user_sex, int  user_age, String user_address, String create_people, Date create_time);

}
