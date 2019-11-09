package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;

import java.util.List;

public interface OrganService {
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
