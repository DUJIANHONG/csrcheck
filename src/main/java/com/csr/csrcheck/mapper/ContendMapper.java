package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Contend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface ContendMapper {

    //查询药企核心竞争力动态信息
    public List<Contend> getContendList( );

    /**
     *根据药企查询药企核心竞争力动态信息
     *  @param company_name
     * @return
     */
    public List<Contend> getContendListpage(@Param(value = "company_name") String company_name);

}
