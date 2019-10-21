package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 15:07
 */
public interface TheirService {

    public List<Product> getAlltheirByproduct_id(int id,String product_name);
}
