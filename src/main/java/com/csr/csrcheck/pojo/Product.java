package com.csr.csrcheck.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @description:产品
 * @author: Administrator
 * @date: Created in 2019/10/14 16:03
 * @version:
 * @modified By:
 */
public class Product {
    //产品表

    private int product_id;             //主键，产品编号
    private String product_name;        //产品名称
    @JsonIgnore
    private int product_type_id;        //产品类型id
    @JsonIgnore
    private int company_id;             //关联公司id
    private String product_territory;   //产品领域
    private int study_appear;           //在研/上市（1：在研，2：上市）
    private String registered;          //注册分类（化1，化2，化3，化4，化5，老化6）
    @JsonIgnore
    private int stage_no;               //阶段编号
    private String patent_no;           //专利号
    @JsonIgnore
    private int patent_t_id;            //专利类型id
    private String approvals_no;        //准字号
    private int domestic_import;        //国产/进口（1国产；2进口）
    private String yieldly;             //产品生产地
    private int iflegal;//是否合法
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date term_of_validity;//有效期限

    public int getIflegal() {
        return iflegal;
    }

    public void setIflegal(int iflegal) {
        this.iflegal = iflegal;
    }

    public Date getTerm_of_validity() {
        return term_of_validity;
    }

    public void setTerm_of_validity(Date term_of_validity) {
        this.term_of_validity = term_of_validity;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }


    /*
     *自定义字段
     */
    private String company_name;//公司名称
    private String patent_t_name;//产品类型名称
    private String stage_name;  //阶段名称
    @JsonIgnore
    private String licence_no;  //许可证号
    @JsonIgnore
    private String production;  //生产范围
    @JsonIgnore
    private String organization;//受管辖机构
    @JsonIgnore
    private String expire_date; //许可证到期时间

    public String getPatent_t_name() {
        return patent_t_name;
    }

    public void setPatent_t_name(String patent_t_name) {
        this.patent_t_name = patent_t_name;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(int product_type_id) {
        this.product_type_id = product_type_id;
    }

    public String getProduct_territory() {
        return product_territory;
    }

    public void setProduct_territory(String product_territory) {
        this.product_territory = product_territory;
    }

    public int getStudy_appear() {
        return study_appear;
    }

    public void setStudy_appear(int study_appear) {
        this.study_appear = study_appear;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public int getStage_no() {
        return stage_no;
    }

    public void setStage_no(int stage_no) {
        this.stage_no = stage_no;
    }

    public String getPatent_no() {
        return patent_no;
    }

    public void setPatent_no(String patent_no) {
        this.patent_no = patent_no;
    }

    public int getPatent_t_id() {
        return patent_t_id;
    }

    public void setPatent_t_id(int patent_t_id) {
        this.patent_t_id = patent_t_id;
    }

    public String getApprovals_no() {
        return approvals_no;
    }

    public void setApprovals_no(String approvals_no) {
        this.approvals_no = approvals_no;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getDomestic_import() {
        return domestic_import;
    }

    public void setDomestic_import(int domestic_import) {
        this.domestic_import = domestic_import;
    }

    public String getYieldly() {
        return yieldly;
    }

    public void setYieldly(String yieldly) {
        this.yieldly = yieldly;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
}
