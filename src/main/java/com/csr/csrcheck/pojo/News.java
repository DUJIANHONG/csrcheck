package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-24 14:23
 */
public class News {
    //新闻表

    private int id;                //主键
    private String news_title;     //新闻标题
    private String news_content;   //新闻内容
    private String img_url;        //图片路径
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
