package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-21 9:25
 */
public class Patent {
    //专利表
    private int id;            //主键
    private int peoduct_id;    //关联产品id
    private String patent_no;  //专利号
    private int patent_type_id;//专利类型名称

    //自定义字段
    private int patentcount;     //专利数量
    private String product_name; //产品名称
    private String patent_t_name;//专利类型名称
    private String company_name; //公司名称
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeoduct_id() {
        return peoduct_id;
    }

    public void setPeoduct_id(int peoduct_id) {
        this.peoduct_id = peoduct_id;
    }

    public String getPatent_no() {
        return patent_no;
    }

    public void setPatent_no(String patent_no) {
        this.patent_no = patent_no;
    }

    public int getPatent_type_id() {
        return patent_type_id;
    }

    public void setPatent_type_id(int patent_type_id) {
        this.patent_type_id = patent_type_id;
    }

    public int getPatentcount() {
        return patentcount;
    }

    public void setPatentcount(int patentcount) {
        this.patentcount = patentcount;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPatent_t_name() {
        return patent_t_name;
    }

    public void setPatent_t_name(String patent_t_name) {
        this.patent_t_name = patent_t_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
