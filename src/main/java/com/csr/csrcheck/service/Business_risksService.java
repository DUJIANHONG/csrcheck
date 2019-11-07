package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

public interface Business_risksService {
    /**
     * 查询经营风险
     * @param
     * @return
     */
    public List<Business_risks> getBusiness_riskslist();


    /**
     * 分页查询经营风险
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum,int pageSize,String company_name);
}
