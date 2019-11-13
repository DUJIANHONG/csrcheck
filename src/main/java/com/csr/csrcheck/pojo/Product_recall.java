package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-21 16:21
 */
public class Product_recall {
    //产品召回表

    private int id;                 //主键
    private int product_id;         //关联产品id
    private String keywords_remarks;//关键词备注
    private String recall_content;  //召回内容


    //自定义字段
    private String company_name;     //公司名称
    private String product_name;     //产品名称
    private String product_t_name;   //产品类型名称

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_t_name() {
        return product_t_name;
    }

    public void setProduct_t_name(String product_t_name) {
        this.product_t_name = product_t_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getKeywords_remarks() {
        return keywords_remarks;
    }

    public void setKeywords_remarks(String keywords_remarks) {
        this.keywords_remarks = keywords_remarks;
    }

    public String getRecall_content() {
        return recall_content;
    }

    public void setRecall_content(String recall_content) {
        this.recall_content = recall_content;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
