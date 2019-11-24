package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.*;
import org.apache.ibatis.annotations.Param;

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

    /**
     *
     * 新增产品页面所需的关联查询
     */
    List<Product_type> selectProduct_type();

    List<Patent_type> selectPatent();

    List<Company> selectCompany();

    List<Stage> selectStage();

    /**
     * 新增产品
     */
    int addproduct(Product product);

    /**
     *查询产品id和产品名称
     *  @return
     */
    List<Product> list();
    /**
     * 修改前根据产品id查询产品信息
     */
    Product selectByproduct_id(int product_id);
    /**
     * 修改产品信息
     */
    int updateProduct(Product product);
}
