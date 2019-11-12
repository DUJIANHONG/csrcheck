package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 11:24
 * @version:
 * @modified By:
 */
public class Stock_alteration {

    private int id;             //主键（股权变更表）
    private int investor_id;    //关联的股东id
    private String  type;           //股东类型（1公司；2人）
    private String ratio_after; //变更后
    private String ratio_before;//变更前
    private String share_change;//持股变化（股）
    private String increase_decrease;//增减情况
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date change_time;    //变更时间
    private String shareholder_name; //股东名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvestor_id() {
        return investor_id;
    }

    public void setInvestor_id(int investor_id) {
        this.investor_id = investor_id;
    }

    public String  getType() {
        return type;
    }

    public void setType(String  type) {
        this.type = type;
    }

    public String getRatio_after() {
        return ratio_after;
    }

    public void setRatio_after(String ratio_after) {
        this.ratio_after = ratio_after;
    }

    public String getRatio_before() {
        return ratio_before;
    }

    public void setRatio_before(String ratio_before) {
        this.ratio_before = ratio_before;
    }

    public String getShare_change() {
        return share_change;
    }

    public void setShare_change(String share_change) {
        this.share_change = share_change;
    }

    public String getIncrease_decrease() {
        return increase_decrease;
    }

    public void setIncrease_decrease(String increase_decrease) {
        this.increase_decrease = increase_decrease;
    }

    public Date getChange_time() {
        return change_time;
    }

    public void setChange_time(Date change_time) {
        this.change_time = change_time;
    }

    public String getShareholder_name() {
        return shareholder_name;
    }

    public void setShareholder_name(String shareholder_name) {
        this.shareholder_name = shareholder_name;
    }
}
