package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Product;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 13:49
 */
public interface TheirMapper {

    //查询产品表中的所有化妆品
    public List<Product> getAlltheirByproduct_id(int id,String product_name);
}
