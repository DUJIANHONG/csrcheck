package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Objects;

/**
 * @description:意见反馈
 * @author: Administrator
 * @String: Created in 2019/11/1 16:33
 * @version:
 * @modified By:
 */
public class Feedback {

    private int id;                 //主键id
    private String content;         //反馈内容
    private String information;     //联系方式
    private String commitdata;        //提交时间

    public String getCommitdata() {
        return commitdata;
    }

    public void setCommitdata(String commitdata) {
        this.commitdata = commitdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return id == feedback.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
