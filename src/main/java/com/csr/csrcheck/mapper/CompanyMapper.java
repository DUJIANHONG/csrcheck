package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Special_bulletin;
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

    /**
     * 分页查询所有信息
     * @return
     */
    public List<Company> getCompanyPage();


    //查询公司特别公告
    public List<Special_bulletin> getAll();


}
