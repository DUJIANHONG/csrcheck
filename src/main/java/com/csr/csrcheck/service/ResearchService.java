package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.pojo.Research;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface ResearchService {

    //查询信用研究信息
    public List<Research> getResearchList();


    /**
     *根据药企名称分页查询信用研究信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum, int pageSize, String company_name);

}
