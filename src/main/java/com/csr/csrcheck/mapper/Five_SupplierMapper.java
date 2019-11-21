package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Five_supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/8 15:15
 * @version:
 * @modified By:
 */
public interface  Five_SupplierMapper {

    /**
     * 查询前五大供应商
     * @return
     */
    List<Five_supplier> getListFive(@Param(value = "supplier_name") String supplier_name);


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
