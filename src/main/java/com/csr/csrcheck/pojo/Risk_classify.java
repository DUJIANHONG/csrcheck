package com.csr.csrcheck.pojo;

public class Risk_classify {
    private int id;//主键（风险分类表）
    private String risk_classify_name ;//风险分类的名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisk_classify_name() {
        return risk_classify_name;
    }

    public void setRisk_classify_name(String risk_classify_name) {
        this.risk_classify_name = risk_classify_name;
    }
}
