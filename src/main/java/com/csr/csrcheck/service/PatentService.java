package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface PatentService {
    //查询該公司旗下的所有专利
    public List<Product> getListByProduct(int company_id);
}
