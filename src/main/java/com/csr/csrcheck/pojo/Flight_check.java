package com.csr.csrcheck.pojo;

import java.util.Date;

/**
 * @author Karry
 * @create 2019-10-17 10:15
 */
public class Flight_check {
    //飞行检查表

    private int id;                 //主键
    private int company_id;         //涉及公司id
    private int product_id;         //涉及产品id
    private String punish;          //所受处罚
    private Date term_of_validity;  //有效期限

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public Date getTerm_of_validity() {
        return term_of_validity;
    }

    public void setTerm_of_validity(Date term_of_validity) {
        this.term_of_validity = term_of_validity;
    }
}
