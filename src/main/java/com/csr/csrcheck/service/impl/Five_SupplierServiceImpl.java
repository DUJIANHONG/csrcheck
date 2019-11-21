package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Five_SupplierMapper;
import com.csr.csrcheck.pojo.Five_supplier;
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

    @Override
    public int addFivesupplier(Five_supplier five_Supplier) {
        int row=fiveSupplierMapper.addFivesupplier(five_Supplier);
        if(row!=1){
            throw new CompanyException("添加失败");
        }
        return row;
    }

    @Override
    public int updateFiveSupplier(Five_supplier five_Supplier) {
        int row=fiveSupplierMapper.updateFiveSupplier(five_Supplier);
        if(row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public int deleteFiveSupplier(int id) {
        int row=fiveSupplierMapper.deleteFiveSupplier(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    @Override
    public Five_supplier fingfiveByid(int id) {
        return fiveSupplierMapper.fingfiveByid(id);
    }

    private PageInfo<Five_supplier> getPageInfo(int pageNum, int pageSize, String supplier_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Five_supplier> list=fiveSupplierMapper.getListFive(supplier_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
