package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Risk_classify;
import com.csr.csrcheck.pojo.Risk_type;
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

    /**
     *下拉列表展示风险分类
     *  @return
     */
    List<Risk_classify> findbylistclassify();

    /**
     * 下拉列表展示风险类型
     * @return
     */
    List<Risk_type> findbylisttype();
    /**
     * 根据id查找企业分险
     * @param id
     * @return
     */
    Business_risks findlistbyid(int id);
}
