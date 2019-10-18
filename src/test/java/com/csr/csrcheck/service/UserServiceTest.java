package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private IUserService service;
    @Test
    public  void login(){
        String user_name="测试";
        String password="123456";
        User result=service.login(user_name,password);
        System.err.println(result);
    }
}
