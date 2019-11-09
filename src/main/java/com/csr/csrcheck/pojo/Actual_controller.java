package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-18 15:57
 */
public class Actual_controller {
    //公司实际控制人介绍表

    private int id;//主键（股东表）
    private String con_name;//控股人姓名
    private int con_sex ;//性别（1男；2女）
    private String  con_nation;//民族
    private int con_age;//年龄
    private String  con_address;//地址
    private String  con_introduction;//公司控制人简介
    private int relevance_enterprise;//他关联的企业

    /**
     * 自定义字段
     * @return
     */
    private String company_name;        //公司名称

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

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

    public String getCon_nation() {
        return con_nation;
    }

    public void setCon_nation(String con_nation) {
        this.con_nation = con_nation;
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

    public String getCon_introduction() {
        return con_introduction;
    }

    public void setCon_introduction(String con_introduction) {
        this.con_introduction = con_introduction;
    }

    public int getRelevance_enterprise() {
        return relevance_enterprise;
    }

    public void setRelevance_enterprise(int relevance_enterprise) {
        this.relevance_enterprise = relevance_enterprise;
    }
}
