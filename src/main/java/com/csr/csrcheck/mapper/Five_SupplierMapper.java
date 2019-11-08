package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Five_Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/8 15:15
 * @version:
 * @modified By:
 */
public interface Five_SupplierMapper {

    /**
     * 查询前五大供应商
     * @return
     */
    List<Five_Supplier> getListFive(@Param(value = "supplier_name") String supplier_name);
}
