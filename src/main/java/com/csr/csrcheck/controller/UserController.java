package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.User;
import com.csr.csrcheck.service.IUserService;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;
    @GetMapping("login")
    public JsonResult<User>login(String user_name,
                                 String password, HttpSession session, Model model){
        User data=userService.login(user_name,password);
        session.setAttribute("user_id",data.getUser_id());
        session.setAttribute("user_name",data.getUser_name());
        return new JsonResult<User>(SUCCESS,OK,data);
    }
}
