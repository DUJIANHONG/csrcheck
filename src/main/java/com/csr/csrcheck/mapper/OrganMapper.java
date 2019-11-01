package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Company;

import java.util.List;

public interface OrganMapper {
   /**
     * 查询前十大投资机构信息
     * @param
     * @return
     */
    public List<Company> getOrganlist();
    /**
     * 查询基本信息
     * @param
     * @return
     */
    public List<Company> getOrganlist2();
}
