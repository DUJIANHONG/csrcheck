package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Product_apparatusService {


    /**
     * 根据医疗器械产品名称模糊查询医疗器械数据
     * @param product_name 产品名称
     * @return
     */
    public List<Product> getProductlistbyname(@Param(value = "product_name") String product_name);


}
