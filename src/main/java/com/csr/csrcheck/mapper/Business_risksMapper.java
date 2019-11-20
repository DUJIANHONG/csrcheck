package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Risk_classify;
import com.csr.csrcheck.pojo.Risk_type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Business_risksMapper {
    /**
     * 查询经营风险
     * @param
     * @return
     */
    public List<Business_risks> getBusiness_riskslist();

    /**
     * 根据企业名称模糊查询风险$分页
     * @param company_name
     * @return
     */
    public List<Business_risks> getListpage(@Param(value = "company_name") String company_name);


    /**
     * 增加企业风险
     * @param business_risks
     * @return
     */
    int addBusiness(Business_risks business_risks);

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


}
