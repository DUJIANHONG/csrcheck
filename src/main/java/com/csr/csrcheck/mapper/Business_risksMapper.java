package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Lawsuit;
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
}
