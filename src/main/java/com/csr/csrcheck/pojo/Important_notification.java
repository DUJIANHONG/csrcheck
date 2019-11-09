package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-26 14:30
 */
public class Important_notification {

    //(化妆品重要通报表）
    private int id;              //主键
    private String title;        //标题
    private String content;      //内容
    private int product_id;      //关联化妆品
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date release_time;   //发布时间

    /**
     * 自定义字段
     * @return
     */
    private String product_name;        //产品名称

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }
}
