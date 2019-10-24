package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description:公司
 * @author: Administrator
 * @date: Created in 2019/10/14 15:33
 * @version:
 * @modified By:
     */
public class Company {

    private int id;                     //主键id
    private String company_name;        //公司名称
    private String company_address;     //公司地址
    private String type_ownership;      //公司所属类型
    private String main_business;       //主营业务
    private int certificate_id;         //证书id
    private String strategic_focus;     //战略重点
    private int listed_unlisted;        //上市/未上市（1上市；2未上市）
    private String ten_shareholders;    //前十大股东
    private String introduction_controller_id;  //公司实际控制人id
    private int company_ranking;        //公司排名
    private String business_license;    //营业执照图片路径
    private String exequatur;           //许可证图片路径
    private String licence_no;           //许可证编号
    private String production;          //生产范围
    public int getListed_unlisted() {
        return listed_unlisted;
    }

    public void setListed_unlisted(int listed_unlisted) {
        this.listed_unlisted = listed_unlisted;
    }


    /*
     *自定义字段
     */
    private String product_name; //产品名称
    private String certificate_no;//营业执照编号
    private String user_name;//用户名
    private String product_t_name;//产品类型名称




    public String getProduct_t_name() {
        return product_t_name;
    }

    public void setProduct_t_name(String product_t_name) {
        this.product_t_name = product_t_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCertificate_no() {
        return certificate_no;
    }

    public void setCertificate_no(String certificate_no) {
        this.certificate_no = certificate_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getType_ownership() {
        return type_ownership;
    }

    public void setType_ownership(String type_ownership) {
        this.type_ownership = type_ownership;
    }

    public String getMain_business() {
        return main_business;
    }

    public void setMain_business(String main_business) {
        this.main_business = main_business;
    }

    public int getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(int certificate_id) {
        this.certificate_id = certificate_id;
    }

    public String getStrategic_focus() {
        return strategic_focus;
    }

    public void setStrategic_focus(String strategic_focus) {
        this.strategic_focus = strategic_focus;
    }

    public String getTen_shareholders() {
        return ten_shareholders;
    }

    public void setTen_shareholders(String ten_shareholders) {
        this.ten_shareholders = ten_shareholders;
    }

    public String getIntroduction_controller_id() {
        return introduction_controller_id;
    }

    public void setIntroduction_controller_id(String introduction_controller_id) {
        this.introduction_controller_id = introduction_controller_id;
    }
    public int getCompany_ranking() {
        return company_ranking;
    }

    public void setCompany_ranking(int company_ranking) {
        this.company_ranking = company_ranking;
    }

    public String getBusiness_license() {
        return business_license;
    }

    public void setBusiness_license(String business_license) {
        this.business_license = business_license;
    }

    public String getExequatur() {
        return exequatur;
    }

    public void setExequatur(String exequatur) {
        this.exequatur = exequatur;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}