package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Exponent;
import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface ExponentService {

    //查询指数发布信息
    public List<Exponent> getExponentList();


    /**
     *根据药企名称分页查询指数发布
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum, int pageSize, String company_name);

}
