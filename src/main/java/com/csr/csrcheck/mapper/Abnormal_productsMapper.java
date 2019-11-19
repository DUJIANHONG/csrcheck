package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Abnormal_products;

import java.util.List;

import com.csr.csrcheck.pojo.Abnormal_products;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: dujianhong
 * @date: Created in 2019/10/17 20:11
 * @version:
 * @modified By:
 */
public interface Abnormal_productsMapper {
    //查询所有不合格产品
    public List<Abnormal_products> getAllProduct();

    /**
     * 根据产品名称查询产品异常通报
     * @param
     * @return
     */
   public List<Abnormal_products> abnormallsit(@Param(value = "product_name") String product_name);
}
