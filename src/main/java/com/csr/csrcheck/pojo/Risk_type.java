package com.csr.csrcheck.pojo;

public class Risk_type {
   private int  id;//主键（风险类型表）
   private String  risk_type_name ;//风险类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisk_type_name() {
        return risk_type_name;
    }

    public void setRisk_type_name(String risk_type_name) {
        this.risk_type_name = risk_type_name;
    }
}
