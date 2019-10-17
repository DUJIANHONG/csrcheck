package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description:用户角色
 * @author: Administrator
 * @date: Created in 2019/10/14 16:07
 * @version:
 * @modified By:
 */
public class Role {
    //角色表
    private int role_id;         //角色id
    private String role_name;    // 角色名称

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return role_id == role.role_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
