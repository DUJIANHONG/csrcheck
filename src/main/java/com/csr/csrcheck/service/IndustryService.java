package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.pojo.Industry;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface IndustryService {

    //查询专业行业信息
    public List<Industry> getIndustryList();


    /**
     *根据药企名称分页查询专业行业信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum, int pageSize, String company_name);

}
