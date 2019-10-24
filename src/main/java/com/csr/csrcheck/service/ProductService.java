package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    /**
     * 查询产品信息
     * @return
     */
    public List<Product> getProductlist();

    /**
     * 根据产品名称模糊查询
     * @param product_name 产品名称
     * @return
     */
    public List<Product> getProductlistbyname(@Param(value = "product_name") String product_name);

}
