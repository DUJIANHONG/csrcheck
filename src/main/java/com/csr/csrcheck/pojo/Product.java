package com.csr.csrcheck.pojo;

import java.util.Date;
import java.util.Objects;

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
    private int product_type_id;        //产品类型
    private int company_id;             //关联公司id
    private String product_territory;   //产品领域
    private int study_appear;           //在研/上市（1：在研，2：上市）
    private String registered;          //注册分类（化1，化2，化3，化4，化5，老化6）
    private int stage_no;               //阶段编号
    private String patent_no;           //专利号
    private int patent_type_id;         //专利类型id
    private int domestic_import;        //国产/进口（1国产；2进口）
    private String yieldly;             //产品生产地

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

    public int getPatent_type_id() {
        return patent_type_id;
    }

    public void setPatent_type_id(int patent_type_id) {
        this.patent_type_id = patent_type_id;
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
}
