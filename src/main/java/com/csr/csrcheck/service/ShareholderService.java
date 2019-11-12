package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 10:36
 * @version:
 * @modified By:
 */
public interface ShareholderService {

    /**
     * 根据公司名称、股东名称，股份类型分页查询
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @return
     */
    public PageResult getListPage( int pageNum,int pageSize,String shareholder_name,
                                   String share_type,
                                   String company_name);
}
