package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 15:07
 */
public interface TheirService {

    public List<Product> getAlltheirByproduct_id(int id,String product_name);

    //查询进口化妆品品牌
    public  List<Product> gettheirByimport(int t_id, int i_id);

    //查询化妆品生产厂家
    public List<Product> getComanyByProduct_t_id(int t_id);
}
