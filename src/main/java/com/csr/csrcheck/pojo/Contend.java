package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Contend {

    private int id;//主键（竞争力表）
    private int company_id;//关联公司ID
    private String title;//竞争力信息标题
    private String content;//内容
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//转换时间格式
    private Date  time;//发布时间

    /**
     * 自定义字段
     * @return
     */
    private String company_name;        //公司名称

    private Company company;            //公司

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
