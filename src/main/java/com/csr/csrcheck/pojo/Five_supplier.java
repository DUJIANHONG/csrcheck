package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-31 15:49
 */
public class Five_supplier {
    //公司前五大供应商
    private int id;               //主键
    private int company_id;       //供应商关联的公司
    private String supplier_name; //供应商名称
    private int announcement_date;//报告期
    private String amt;           //采购金额（万元）
    private String alias;         //简称
    private String relationship;  //关联关系
    private String dataSource;    //数据来源
    private String ratio;         //采购占比

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

    public int getAnnouncement_date() {
        return announcement_date;
    }

    public void setAnnouncement_date(int announcement_date) {
        this.announcement_date = announcement_date;
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
}
