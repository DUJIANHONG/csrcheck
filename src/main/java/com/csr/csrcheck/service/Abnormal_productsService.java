package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-25 17:15
 */
public interface Abnormal_productsService {
    //查询所有不合格产品
    public List<Abnormal_products> getAbnormalByTheir_id(int product_type_id);

    //根据产品名称分页查询
    public PageResult abnormallsitpage(int pageNum, int pageSize, String product_name);

}
