package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Product_type;

import java.util.List;

/**
 * @description:
 * @author: dujianhong
 * @date: Created in 2019/10/17 20:13
 * @version:
 * @modified By:
 */
public interface Product_typeMapper {

    /**
     * 查询产品类型
     * @return
     */
    List<Product_type> getlist();
}
