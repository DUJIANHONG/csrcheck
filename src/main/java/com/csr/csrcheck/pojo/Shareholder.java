package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-11-02 15:23
 */
public class Shareholder {
    //股东表
    private int id;                 //主键
    private String shareholder_name;//股东名称
    private String share_type;      //股份类型
    private String number_of_shares;//持股数（单位：万/亿）
    private String proportion;      //占流通股本比例
    private int company_id;         //关联企业id

    private String company_name;              //公司名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShareholder_name() {
        return shareholder_name;
    }

    public void setShareholder_name(String shareholder_name) {
        this.shareholder_name = shareholder_name;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public String getNumber_of_shares() {
        return number_of_shares;
    }

    public void setNumber_of_shares(String number_of_shares) {
        this.number_of_shares = number_of_shares;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
