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
    private int product_number;         //主键，产品编号
    private String product_name;        //产品名称
    private String product_type;        //产品类型
    private int domestic_import;        //国产/进口（1：国产，2：进口）
    private String production_address;  //生产地址
    private Date Date_manufacture;      //生产日期
    private Date product_expirationtime;//产品到期时间

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getDomestic_import() {
        return domestic_import;
    }

    public void setDomestic_import(int domestic_import) {
        this.domestic_import = domestic_import;
    }

    public String getProduction_address() {
        return production_address;
    }

    public void setProduction_address(String production_address) {
        this.production_address = production_address;
    }

    public Date getDate_manufacture() {
        return Date_manufacture;
    }

    public void setDate_manufacture(Date date_manufacture) {
        Date_manufacture = date_manufacture;
    }

    public Date getProduct_expirationtime() {
        return product_expirationtime;
    }

    public void setProduct_expirationtime(Date product_expirationtime) {
        this.product_expirationtime = product_expirationtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return product_number == product.product_number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_number);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_number=" + product_number +
                ", product_name='" + product_name + '\'' +
                ", product_type='" + product_type + '\'' +
                ", domestic_import=" + domestic_import +
                ", production_address='" + production_address + '\'' +
                ", Date_manufacture=" + Date_manufacture +
                ", product_expirationtime=" + product_expirationtime +
                '}';
    }
}
