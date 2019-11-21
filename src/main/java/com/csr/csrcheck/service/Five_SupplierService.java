package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Five_supplier;
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

    /**
     * 增加前五大供应商
     * @param  five_Supplier
     * @return
     */
    int addFivesupplier(Five_supplier five_Supplier);

    /**
     * 修改前五大供应商
     * @param  five_Supplier
     * @return
     */
    int updateFiveSupplier(Five_supplier five_Supplier);


    /**
     * 删除前五大供应商
     * @param id
     * @return
     */
    int deleteFiveSupplier(int id);

    /**
     *根据id查找前五大供应商
     *  @param id
     * @return
     */
    Five_supplier fingfiveByid(int id);
}
