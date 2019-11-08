package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

public interface ClinicService {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Clinic> getCliniclist( );


    /**
     *根据产品名称分页查询临床信息
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    PageResult getListpage(int pageNum,int pageSize,String product_name);
}
