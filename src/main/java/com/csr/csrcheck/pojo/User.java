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
    private int userid;         //用户id
    private String user_name;   //用户名
    private int user_roleid;    //用户角色id
    private String create_people;//创建人
    private Date create_time;    //创建时间
    private String login_status; //最近登录状态

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_roleid() {
        return user_roleid;
    }

    public void setUser_roleid(int user_roleid) {
        this.user_roleid = user_roleid;
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

    public String getLogin_status() {
        return login_status;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userid == user.userid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", user_name='" + user_name + '\'' +
                ", user_roleid=" + user_roleid +
                ", create_people='" + create_people + '\'' +
                ", create_time=" + create_time +
                ", login_status='" + login_status + '\'' +
                '}';
    }
}
