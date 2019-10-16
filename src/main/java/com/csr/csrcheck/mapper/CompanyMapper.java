package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Company;

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
    public List<Company> getCommpanylist();

}
