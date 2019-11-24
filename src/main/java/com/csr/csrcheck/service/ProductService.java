package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
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
    PageResult listpage(int pageNum, int pageSize, String product_name);

    /**
     *查询产品id和产品名称
     *  @return
     */
    List<Product> list();


    /**
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
     * 修改前根据产品id查询产品信息
     */
    Product selectByproduct_id(int product_id);

    /**
     * 修改产品信息
     */
    int updateProduct(Product product);
}
