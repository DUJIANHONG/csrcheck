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
    private int product_id;             //在售产品编号
    private String strategic_focus;     //战略重点
    private String ten_shareholders;    //前十大股东
    private String controller_company;  //公司实际控制人
    private String introduction_controller; //控制人简介
    private int number_patents;        //专利数量
    private  int company_ranking;      //公司排名

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public String getController_company() {
        return controller_company;
    }

    public void setController_company(String controller_company) {
        this.controller_company = controller_company;
    }

    public String getIntroduction_controller() {
        return introduction_controller;
    }

    public void setIntroduction_controller(String introduction_controller) {
        this.introduction_controller = introduction_controller;
    }

    public int getNumber_patents() {
        return number_patents;
    }

    public void setNumber_patents(int number_patents) {
        this.number_patents = number_patents;
    }

    public int getCompany_ranking() {
        return company_ranking;
    }

    public void setCompany_ranking(int company_ranking) {
        this.company_ranking = company_ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return id == company.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", company_address='" + company_address + '\'' +
                ", type_ownership='" + type_ownership + '\'' +
                ", main_business='" + main_business + '\'' +
                ", product_id=" + product_id +
                ", strategic_focus='" + strategic_focus + '\'' +
                ", ten_shareholders='" + ten_shareholders + '\'' +
                ", controller_company='" + controller_company + '\'' +
                ", introduction_controller='" + introduction_controller + '\'' +
                ", number_patents=" + number_patents +
                ", company_ranking=" + company_ranking +
                '}';
    }
}
