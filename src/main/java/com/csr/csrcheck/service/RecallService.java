package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product_recall;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:47
 */
public interface RecallService {
    //查询所有被召回公司
    public List<Product_recall> getlist();
}