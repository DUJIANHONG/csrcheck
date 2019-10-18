package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMappperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void findUser_name(){
        String user_name="cs";
        User result=userMapper.findUser_name(user_name);
        System.err.println(result);
    }
}
