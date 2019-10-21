package com.csr.csrcheck.pojo;

/**
 * @author Karry
 * @create 2019-10-17 10:25
 */
public class Product_type {
    //产品类型表

    private int id;                 //主键
    private String product_t_name;   //产品类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_t_name() {
        return product_t_name;
    }

    public void setProduct_t_name(String product_t_name) {
        this.product_t_name = product_t_name;
    }
}
