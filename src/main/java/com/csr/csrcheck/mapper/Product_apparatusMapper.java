package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/14 16:24
 * @version:
 * @modified By:
 */
public interface Product_apparatusMapper {



    /**
     * 根据医疗器械产品名称模糊查询医疗器械数据
     * @param product_name 产品名称
     * @return
     */
    public List<Product> getProductlistbyname(@Param(value = "product_name") String product_name);


}
