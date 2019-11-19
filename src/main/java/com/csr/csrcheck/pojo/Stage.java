package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-17 10:26
 */
public class Stage {
    //产品研究阶段表

    private int id;             //主键
    private String stage_name;  //阶段名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }
}
