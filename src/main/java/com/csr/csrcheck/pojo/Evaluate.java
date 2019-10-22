package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-21 16:16
 */
public class Evaluate {
    //一致性评价表

    private int id;                     //主鍵
    private String accept_no;           //受理号
    private int product_id;             //关联产品id
    private String english_name;        //英文名称
    private String specification;       //规格
    private String agent_type;          //剂型
    private String adaptation_disease;  //适应症
    private int company_id;             //关联公司id
    /**
     * 自定义字段
     * @return
     */
    private String company_name;        //公司名称
    private String product_name;        //产品名称

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccept_no() {
        return accept_no;
    }

    public void setAccept_no(String accept_no) {
        this.accept_no = accept_no;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public String getAdaptation_disease() {
        return adaptation_disease;
    }

    public void setAdaptation_disease(String adaptation_disease) {
        this.adaptation_disease = adaptation_disease;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
