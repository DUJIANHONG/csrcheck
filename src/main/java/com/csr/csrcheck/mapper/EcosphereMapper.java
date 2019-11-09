package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Five_supplier;
import com.csr.csrcheck.pojo.Stock_alteration;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-31 17:24
 */
public interface EcosphereMapper {

    //查询该公司的前五大供应商
    public List<Five_supplier> getAllSupplier(int company_id);

    //查询股权变更
    public List<Stock_alteration> getAllAlteration(int company_id);
}
