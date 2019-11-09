package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Abnormal_products;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-25 17:15
 */
public interface Abnormal_productsService {
    //查询所有不合格产品
    public List<Abnormal_products> getAllProduct();
}
