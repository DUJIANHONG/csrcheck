package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @description:重要通报
 * @author: Administrator
 * @date: Created in 2019/11/9 14:26
 * @version:
 * @modified By:
 */
public class Important_notification {

    private int id;                         //主键（化妆品重要通报表）
    private String title;                   //标题
    private String content;                 //通报内容
    private int product_id;                 //关联产品id
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date release_time;              //发布日期

    //关联表字段
    private String product_name;            //产品名称
    private String product_t_name;          //产品类型名称

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_t_name() {
        return product_t_name;
    }

    public void setProduct_t_name(String product_t_name) {
        this.product_t_name = product_t_name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Important_notification)) return false;
        Important_notification that = (Important_notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "important_notification{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", product_id=" + product_id +
                ", release_time=" + release_time +
                '}';
    }
}
