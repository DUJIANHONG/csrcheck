package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-21 16:13
 */
public class Clinic {
    //临床表

    private int id;                 //主键
    private int product_id;         //关联药品id
    private String record_number;   //登记号
    private String  adaptation_disease; //适应症
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date record_date;       //登记日期

    /**
     * 自定义字段
     * @return
     */
    private String product_name;        //产品名称
    private String company_name;        //公司名称

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getRecord_number() {
        return record_number;
    }

    public void setRecord_number(String record_number) {
        this.record_number = record_number;
    }

    public String getAdaptation_disease() {
        return adaptation_disease;
    }

    public void setAdaptation_disease(String adaptation_disease) {
        this.adaptation_disease = adaptation_disease;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }
}
