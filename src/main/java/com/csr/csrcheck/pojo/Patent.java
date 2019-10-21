package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-21 9:25
 */
public class Patent {
    //专利表
    private int id;            //主键
    private int company_id;    //关联公司id
    private String patent_no;  //专利号
    private int patent_type_id;//专利类型名称

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
}
