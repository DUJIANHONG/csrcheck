package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-26 11:21
 */
public class Special_bulletin {
    //企业特别公告
    private int id;             //主键
    private String title;       //公告标题
    private String content;     //.pdf的存放路径
    private int company_id;     //关联公司id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date release_time;  //公告发布时间

    //自定义字段
    private String company_name;//公司名称

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

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
