package com.csr.csrcheck.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @description:用户
 * @author: Administrator
 * @date: Created in 2019/10/14 16:11
 * @version:
 * @modified By:
 */
public class User {
    private int user_id;          //用户id
    private String user_name;    //用户名
    private String password;     //密码
    private int user_roleid;     //用户角色id
    private int user_sex;        //性别(1男；2女)
    private int user_age;        //年龄
    private String user_address; //住址
    private String create_people;//创建人
    private Date create_time;    //创建时间


    private String role_name;     //角色名称

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_roleid() {
        return user_roleid;
    }

    public void setUser_roleid(int user_roleid) {
        this.user_roleid = user_roleid;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getCreate_people() {
        return create_people;
    }

    public void setCreate_people(String create_people) {
        this.create_people = create_people;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }




    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", user_roleid=" + user_roleid +
                ", user_sex=" + user_sex +
                ", user_age=" + user_age +
                ", user_address='" + user_address + '\'' +
                ", create_people='" + create_people + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                user_roleid == user.user_roleid &&
                user_sex == user.user_sex &&
                user_age == user.user_age &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(user_address, user.user_address) &&
                Objects.equals(create_people, user.create_people) &&
                Objects.equals(create_time, user.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_name, password, user_roleid, user_sex, user_age, user_address, create_people, create_time);
    }
}
