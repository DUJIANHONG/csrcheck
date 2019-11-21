package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-11-01 10:44
 */
public class Stock_alteration {
    //股权变更
    private int id;                  //主键
    private int investor_id;         //关联的股东id
    private int type;                //股东类型（1公司；2人）
    private String ratio_after;      //变更后
    private String ratio_before;     //变更前
    private String share_change;     //持股变化（股）
    private String increase_decrease;//增减情况
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date change_time;        //变更时间

    //自定义字段
    private String shareholder_name;    //股东名称
    private String share_type;          //股份类型
    private String number_of_shares;    //持股数（单位：万/亿）

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
