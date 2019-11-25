package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.User;
import com.csr.csrcheck.service.IUserService;
import com.csr.csrcheck.util.Constants;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@RequestMapping("users")
@Slf4j
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    /**
     * 登录
     * @param user_name
     * @param password
     * @param session
     * @return
     */
    @GetMapping("login")
    public JsonResult<User>login(String user_name,
                                 String password, HttpSession session){
        User data=userService.login(user_name,password);
        //放到session
        session.setAttribute("user_id",data.getUser_id());
        session.setAttribute("user_name",data.getUser_name());
        session.setAttribute("role_name",data.getRole_name());
        session.setAttribute(Constants.USER_SESSION,data);
        log.info("user_id:"+getUidFromSession(session));
        return new JsonResult<User>(code,OK,data);
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("logout")
    public JsonResult<Void> logout(HttpSession session) {
        //清除session
         session.removeAttribute(Constants.USER_SESSION);
        return new JsonResult<Void>(code,OK);
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping(path="change_password", method=RequestMethod.POST)
    public JsonResult<Void> changePassword(
             String oldPassword,
             String newPassword,
            HttpSession session) {
            Integer userid=getUidFromSession(session);
            log.info("changePassword-------------------->userid:"+userid);
            userService.UpdatePassword(userid,oldPassword,newPassword);
        return new JsonResult<>(code,OK);
    }

    /**
     *根据id修改用户信息
     *  @param user_name
     * @param user_sex
     * @param user_age
     * @param user_address
     * @param session
     * @return
     */
    @RequestMapping(path="change_user", method=RequestMethod.POST)
    public JsonResult<Void> chageUser(String user_name,
                                      int user_sex,int user_age,
                                      String user_address,HttpSession session){
        int id=getUidFromSession(session);
        userService.UpdateUser(id,user_name,user_sex,user_age,user_address);
        return new JsonResult<>(code,OK);
    }

    /**
     * 更新用户头像
     * @param
     * @param request
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(path="change_Img", method=RequestMethod.POST)
    public JsonResult<Void> chageUserImg(HttpServletRequest request,
                                         MultipartFile file,HttpSession session){
        int id=getUidFromSession(session);
        userService.UpdateUser_photo(id,request,file);
        return new JsonResult<>(code,OK);
    }

    /**
     * 显示用户头像
     * @param session
     * @return
     */
    @GetMapping("img")
    public JsonResult<User> findImg(HttpSession session){
        int id=getUidFromSession(session);
       User user=userService.finduser(id);
       return new JsonResult<>(code,OK,user);
    }

    /**
     * 增加管理员
     * @param
     * @param session
     * @return
     */
    @RequestMapping(path="adduser", method=RequestMethod.POST)
    public JsonResult<Void> addUser(String user_name, String password, int   user_sex, int  user_age, String user_address,HttpSession session){
        String name=getUsernameFromSession(session);
       Date time=new Date();
        try {
            userService.addUser(user_name,password,user_sex,user_age,user_address,name,time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<>(code,OK);
    }
}
