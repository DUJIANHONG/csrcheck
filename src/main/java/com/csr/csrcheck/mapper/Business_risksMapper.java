package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Lawsuit;

import java.util.List;

public interface Business_risksMapper {
    /**
     * 查询经营风险
     * @param
     * @return
     */
    public List<Business_risks> getBusiness_riskslist();
}
