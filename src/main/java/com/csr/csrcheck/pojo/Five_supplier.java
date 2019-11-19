package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description: 前五大供应商
 * @author: Administrator
 * @date: Created in 2019/11/8 15:09
 * @version:
 * @modified By:
 */
public class Five_supplier {
    private int id;                                 //主键（前五大供应商）
    private int company_id;                         //供应商关联公司的id
    private String supplier_name;                   //供应商名称
    private int announcement_date;                  //报告期
    private String amt;                             //采购金额（万元）
    private String alias;                           //简称
    private String relationship;                    //关联关系
    private String dataSource;                      //数据来源
    private String ratio;                           //采购占比



    //映射字段
    private String company_name;   //公司名称

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public int getAnnouncement_date() {
        return announcement_date;
    }

    public void setAnnouncement_date(int announcement_date) {
        this.announcement_date = announcement_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Five_supplier)) return false;
        Five_supplier that = (Five_supplier) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Five_Supplier{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", supplier_name=" + supplier_name +
                ", amt='" + amt + '\'' +
                ", alias='" + alias + '\'' +
                ", relationship='" + relationship + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}
