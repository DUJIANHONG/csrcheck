package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:22
 * @version:
 * @modified By:
 */
public interface CompanyService {
    /**
     * 查询公司信息
     * @param
     * @return
     */
    public List<Company> getCommpanylist();


    public List<Company> getCommpanylistbyname(@Param(value = "company_name") String company_name);

    /**
     * 分页查询公司信息&根据公司名称模糊查询
     * @param company_name
     * @return
     */
    public List<Company> getCommpanylistbynames(@Param(value = "company_name") String company_name,
                                                @Param(value = "currentPageNo") Integer currentPageNo,
                                                @Param(value = "pageSize") Integer pageSize);
    /**
     * 查询公司数量
     * @param company_name
     * @return
     */
    public Integer count(@Param(value = "company_name") String company_name);


}
