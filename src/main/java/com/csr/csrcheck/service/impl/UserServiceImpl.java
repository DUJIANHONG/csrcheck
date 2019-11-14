package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.UserMapper;
import com.csr.csrcheck.pojo.User;
import com.csr.csrcheck.service.IUserService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.PasswordNotMatchException;
import com.csr.csrcheck.service.ex.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User login(String user_name, String password) {
        //根据参数user_name查询用户数据
        User result=userMapper.findUser_name(user_name);
        if(result==null){
            throw new UserNotFoundException("用户名不存在");
        }

        // 调用getMd5Password()，基于参数password进行加密
        String md5Password = getMd5Password(password);
        // 测试输出
        System.err.println("UserServiceImpl.login() ---> 验证登录");
        System.err.println("password=" + password);
        System.err.println("md5Password=" + md5Password);
        System.err.println("result.getPassword()=" + result.getPassword());
        // 判断加密后的密码与查询结果中的密码是否不匹配
        if (!result.getPassword().equals(md5Password)) {
            // 是：密码错误，抛出PasswordNotMatchException
            throw new PasswordNotMatchException("密码错误");
        }
       /* result.setCreate_people(null);
        result.setCreate_time(null);
        result.setCreate_time(null);
        result.setLogin_status(null);
        result.setUser_address(null);
        result.setUser_age(0);
        result.setUser_id(0);*/
        return result;
    }

    /**
     * 修改密码
     * @param user_id
     * @param oldpassword  原密码
     * @param newpassworld 新密码
     */
    @Override
    public void UpdatePassword(int user_id,String oldpassword,String newpassworld) {
        User user=userMapper.findUser(user_id);
        if (user==null){
            throw new CompanyException("用户数据不存在");
        }
        String oldMd5password=getMd5Password(oldpassword);
        if(!user.getPassword().equals(oldMd5password)){
            throw new PasswordNotMatchException("原密码错误");
        }
        String newMd5passworld=getMd5Password(newpassworld);
        Integer row = userMapper.UpdatePassword(user_id, newMd5passworld);
        if(row!=1){
            throw new CompanyException("更新失败");
        }
    }

    /**
     *根据user_id查找
     * @param user_id
     * @return
     */
    @Override
    public User finduser(int user_id) {
        User user=userMapper.findUser(user_id);
        if (user==null){
            throw new CompanyException("数据不存在");
        }
        return user;
    }

    /**
     * 执行密码加密
     * @param password 原密码
     * @return 加密后密码
     */
    private String getMd5Password(String password) {
        // 加密规则：在原密码的左侧和右侧均拼接盐值，循环加密5次
        String str =  password ;
        for (int i = 0; i < 5; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        return str;
    }

}
