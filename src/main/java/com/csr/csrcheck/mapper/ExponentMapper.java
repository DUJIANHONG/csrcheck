package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Exponent;
import com.csr.csrcheck.pojo.Research;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface ExponentMapper {

    //查询指数发布信息
    public List<Exponent> getExponentList();

    /**
     *根据指数发布信息
     *  @param company_name
     * @return
     */
    public List<Exponent> getExponentListpage(@Param(value = "company_name") String company_name);

}
