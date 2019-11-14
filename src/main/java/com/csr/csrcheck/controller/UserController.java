package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.User;
import com.csr.csrcheck.service.IUserService;
import com.csr.csrcheck.util.Constants;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


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
        return new JsonResult<User>(SUCCESS,OK,data);
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
        return new JsonResult<Void>(SUCCESS,OK);
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
        return new JsonResult<>(SUCCESS,OK);
    }
}
