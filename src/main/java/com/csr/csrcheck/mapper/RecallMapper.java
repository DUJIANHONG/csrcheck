package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Product_recall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:40
 */
public interface RecallMapper {
    //查询所有被召回公司
    public List<Product_recall> getlist();

    /**
     *根据产品名称，产品类型名称，企业名称分页查询产品召回内容
     *  @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    public  List<Product_recall> getListPage(@Param(value = "company_name") String company_name,
                                             @Param(value = "product_name") String product_name,
                                             @Param(value = "product_t_name") String product_t_name);
}
