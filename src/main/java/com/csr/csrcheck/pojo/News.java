package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-24 14:23
 */
public class News implements Serializable {
    //新闻表

    private int id;                //主键
    private String news_title;     //新闻标题
    private String news_content;   //新闻内容
    private String img_url;        //图片路径
    private String news_name;     //远创作者
    private String position;      //原创者职位
    private String subheading;    //新闻副标题
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;             //新闻日期

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
