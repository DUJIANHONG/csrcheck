package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/14 16:23
 * @version:
 * @modified By:
 */
public interface CompanyMapper {

    /**
     * 查询公司信息
     * @param
     * @return
     */
    public List<Company> getCommpanylist( );


    /**
     * 根据公司名称模糊查询
     * @param company_name
     * @return
     */
    public List<Company> getCommpanylistbyname(@Param(value = "company_name") String company_name);

}
