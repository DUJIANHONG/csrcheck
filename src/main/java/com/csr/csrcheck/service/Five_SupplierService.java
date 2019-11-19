package com.csr.csrcheck.service;

import com.csr.csrcheck.util.PageResult;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/8 15:25
 * @version:
 * @modified By:
 */
public interface Five_SupplierService {

    /**
     *查询前五大供应商
     *  @return
     */
    PageResult getListFive(int pageNum,int pageSize,String supplier_name);
}
