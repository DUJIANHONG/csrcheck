package com.csr.csrcheck.service;


import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateService {
    /**
     * 查询一致性评价信息
     * @param
     * @return
     */
    public List<Evaluate> getEvaluatelist( );

    /**
     * 根据企业名称或者产品名称查询一致性评价信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @return
     */
    PageResult getlistpage(int pageNum,int pageSize,String company_name,String product_name);
}
