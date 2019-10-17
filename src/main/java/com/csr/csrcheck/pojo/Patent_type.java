package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-17 10:21
 */
public class Patent_type {
    //专利类型表

    private int id;         //主键
    private String patent_t_name;  //类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatent_t_name() {
        return patent_t_name;
    }

    public void setPatent_t_name(String patent_t_name) {
        this.patent_t_name = patent_t_name;
    }
}
