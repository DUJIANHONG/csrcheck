package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Five_SupplierMapper;
import com.csr.csrcheck.pojo.Five_Supplier;
import com.csr.csrcheck.service.Five_SupplierService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/8 15:28
 * @version:
 * @modified By:
 */
@Service
public class Five_SupplierServiceImpl implements Five_SupplierService {

    @Resource
    private Five_SupplierMapper fiveSupplierMapper;

    @Override
    public PageResult getListFive(int pageNum,int pageSize,String supplier_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,supplier_name));
    }

    private PageInfo<Five_Supplier> getPageInfo(int pageNum,int pageSize,String supplier_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Five_Supplier> list=fiveSupplierMapper.getListFive(supplier_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
