package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-11-14 9:50
 */
public class Company_news {

    //新闻舆情表
    private int id;                 //主键
    private String title;          //新闻标题
    private String content;        //内容
    private int company_id;        //关联公司id
    private String img_url;        //新闻图片存放路径
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;             //新闻发布时间

    //自定义字段
    private String company_name;    //公司名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
