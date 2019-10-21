package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-18 15:57
 */
public class Actual_controller {
    //公司实际控制人介绍表

    private int id;             //主键
    private String con_name;    //控制人姓名
    private int con_sex;        //性别
    private int con_age;        //年龄
    private String con_address; //地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCon_name() {
        return con_name;
    }

    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public int getCon_sex() {
        return con_sex;
    }

    public void setCon_sex(int con_sex) {
        this.con_sex = con_sex;
    }

    public int getCon_age() {
        return con_age;
    }

    public void setCon_age(int con_age) {
        this.con_age = con_age;
    }

    public String getCon_address() {
        return con_address;
    }

    public void setCon_address(String con_address) {
        this.con_address = con_address;
    }
}
