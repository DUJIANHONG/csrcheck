package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Product;
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

    /**
     *下拉框查询产品名称
     */
    List<Product> selectproduct();
    /**
     增加产品异常信息
     */
    int addabnormal(Abnormal_products abnormal_products);

    /**
     * 修改前根据产品id查询产品异常信息
     */
    Abnormal_products selectByabnormal_id(int id);

    /**
     * 修改产品异常信息
     */
    int updateabnormal(Abnormal_products abnormal_products);

    /**
     * 根据产品id删除
     */
    int deleteabnormalByid(int id);
}
