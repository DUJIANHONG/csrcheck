package com.csr.csrcheck.pojo;

/**
 * 准字类型表
 */
public class approved_by {
    private int id;   //主键（准字表）
    private String approved_t_name;  //准字类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApproved_t_name() {
        return approved_t_name;
    }

    public void setApproved_t_name(String approved_t_name) {
        this.approved_t_name = approved_t_name;
    }
}
