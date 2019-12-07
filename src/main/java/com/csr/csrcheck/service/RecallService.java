package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:47
 */
public interface RecallService {
    //查询所有被召回公司
    public List<Product_recall> getlist();

    /**
     * 根据产品名称，产品类型名称，企业名称分页查询产品召回内容
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    PageResult getlistpage(int pageNum,int pageSize,String company_name,
                          String product_name,
                          String product_t_name);

    /**
     *下拉框查询产品名称
     */
    List<Product> selectproduct();
    /**
     增加产品召回信息
     */
    int addrecall(Product_recall product_recall);

    /**
     * 修改前根据产品id查询产品召回信息
     */
    Product_recall selectByrecall_id(int id);

    /**
     * 修改产品召回信息
     */
    int updaterecall(Product_recall product_recall);

    /**
     * 根据产品召回id删除
     */
    int deleterecallByid(int id);
}
