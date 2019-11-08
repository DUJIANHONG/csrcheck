package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.pojo.Patent;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface ContendService {

    //查询药企核心竞争力动态信息
    public List<Contend> getContendList( );


    /**
     *根据药企名称分页查询药企核心竞争力动态信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum,int pageSize,String company_name);

}
