package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Business_risks;
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

    /**
     * 增加企业风险
     * @param business_risks
     * @return
     */
    void addBusiness(Business_risks business_risks);

    /**
     * 修改企业风险
     * @param business_risks
     * @return
     */
    int updateBusiness(Business_risks business_risks);

    /**
     *删除企业风险
     *  @param id
     * @return
     */
    int deleteBusiness(int id);
}
