package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product_type;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 10:43
 * @version:
 * @modified By:
 */
public interface Product_typeService {
    /**
     * 查询产品类型
     * @return
     */
    List<Product_type> getlist();

}
