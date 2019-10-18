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




}
