package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description: 企业
 * @author: Administrator
 * @date: Created in 2019/10/14 15:47
 * @version:
 * @modified By:
 */
public class Abnormal_products {
    //产品异常通报表

    private int id;                         //主键id
    private int product_id;                 //产品id
    private String packing;                 //包装规格
    private String batch_no;                //批号/生产日期
    private String approval_no;             //标称卫生许可证/批准文号
    private String disqualification;        //不合格项目
    private String inspection_result;       //检验结果
    private String standard_code;           //标准规定
    private String agencies_to_verify;      //机构验证
    private String last;                    //结论
    private String provenance;              //出处（此列存放通报excel表存放的路径）


    //自定义字段
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

    //产品信息
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getApproval_no() {
        return approval_no;
    }

    public void setApproval_no(String approval_no) {
        this.approval_no = approval_no;
    }

    public String getDisqualification() {
        return disqualification;
    }

    public void setDisqualification(String disqualification) {
        this.disqualification = disqualification;
    }

    public String getInspection_result() {
        return inspection_result;
    }

    public void setInspection_result(String inspection_result) {
        this.inspection_result = inspection_result;
    }

    public String getStandard_code() {
        return standard_code;
    }

    public void setStandard_code(String standard_code) {
        this.standard_code = standard_code;
    }

    public String getAgencies_to_verify() {
        return agencies_to_verify;
    }

    public void setAgencies_to_verify(String agencies_to_verify) {
        this.agencies_to_verify = agencies_to_verify;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abnormal_products)) return false;
        Abnormal_products that = (Abnormal_products) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Abnormal_products{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", packing='" + packing + '\'' +
                ", batch_no='" + batch_no + '\'' +
                ", approval_no='" + approval_no + '\'' +
                ", disqualification='" + disqualification + '\'' +
                ", inspection_result='" + inspection_result + '\'' +
                ", standard_code='" + standard_code + '\'' +
                ", agencies_to_verify='" + agencies_to_verify + '\'' +
                ", last='" + last + '\'' +
                ", provenance='" + provenance + '\'' +
                ", product=" + product +
                '}';
    }
}
