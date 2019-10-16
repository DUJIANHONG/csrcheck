package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description: 企业
 * @author: Administrator
 * @date: Created in 2019/10/14 15:47
 * @version:
 * @modified By:
 */
public class Enterprise {

    private int id;                         //主键id
    private String enterprise_number;       //企业编号
    private String enterprise_name;         //企业名称
    private String business_license_number; //营业执照编号
    private String product_number;          //产品编号
    private String enterprise_business_license; //企业营业执照路径
    private String business_license;        //经营许可证路径
    private String enterprise_business_license_lic;//企业营业执照服务器路径
    private String business_license_lic;     //经营许可证服务器路径

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterprise_number() {
        return enterprise_number;
    }

    public void setEnterprise_number(String enterprise_number) {
        this.enterprise_number = enterprise_number;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getBusiness_license_number() {
        return business_license_number;
    }

    public void setBusiness_license_number(String business_license_number) {
        this.business_license_number = business_license_number;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getEnterprise_business_license() {
        return enterprise_business_license;
    }

    public void setEnterprise_business_license(String enterprise_business_license) {
        this.enterprise_business_license = enterprise_business_license;
    }

    public String getBusiness_license() {
        return business_license;
    }

    public void setBusiness_license(String business_license) {
        this.business_license = business_license;
    }

    public String getEnterprise_business_license_lic() {
        return enterprise_business_license_lic;
    }

    public void setEnterprise_business_license_lic(String enterprise_business_license_lic) {
        this.enterprise_business_license_lic = enterprise_business_license_lic;
    }

    public String getBusiness_license_lic() {
        return business_license_lic;
    }

    public void setBusiness_license_lic(String business_license_lic) {
        this.business_license_lic = business_license_lic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enterprise)) return false;
        Enterprise that = (Enterprise) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", enterprise_number='" + enterprise_number + '\'' +
                ", enterprise_name='" + enterprise_name + '\'' +
                ", business_license_number='" + business_license_number + '\'' +
                ", product_number='" + product_number + '\'' +
                ", enterprise_business_license='" + enterprise_business_license + '\'' +
                ", business_license='" + business_license + '\'' +
                ", enterprise_business_license_lic='" + enterprise_business_license_lic + '\'' +
                ", business_license_lic='" + business_license_lic + '\'' +
                '}';
    }
}
