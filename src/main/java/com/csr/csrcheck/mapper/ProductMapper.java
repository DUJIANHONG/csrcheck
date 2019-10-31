package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/14 16:24
 * @version:
 * @modified By:
 */
public interface ProductMapper {
    /**
     * 查询产品信息
     * @return
     */
    public List<Product> getProductlist();

    /**
     * 根据产品名称模糊查询
     * @param product_name 产品名称
     * @return
     */
    public List<Product> getProductlistbyname(@Param(value = "product_name") String product_name);

    /**
     * 根据产品名称模糊查询&分页展示查询结果
     * @param product_name
     * @return
     */
    List<Product> listpage(@Param(value = "product_name") String product_name);
}
