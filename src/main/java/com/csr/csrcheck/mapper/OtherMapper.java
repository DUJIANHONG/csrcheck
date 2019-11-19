package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Exponent;
import com.csr.csrcheck.pojo.Other;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface OtherMapper {

    //查询其他信息
    public List<Other> getOtherList();

    /**
     *根据其他信息
     *  @param company_name
     * @return
     */
    public List<Other> getOtherListpage(@Param(value = "company_name") String company_name);

}
