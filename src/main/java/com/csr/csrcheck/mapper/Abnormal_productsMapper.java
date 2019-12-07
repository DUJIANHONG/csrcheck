package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Abnormal_products;

import java.util.List;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Product;
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
    //查询化妆品不合格产品
    public List<Abnormal_products> getAbnormalByTheir_id(int product_type_id);

    /**
     * 根据产品名称查询产品异常通报
     * @param
     * @return
     */
   public List<Abnormal_products> abnormallsit(@Param(value = "product_name") String product_name);

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
