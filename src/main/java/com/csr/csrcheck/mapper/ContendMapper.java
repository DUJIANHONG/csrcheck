package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.pojo.Patent;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface ContendMapper {

    //查询药企核心竞争力动态信息
    public List<Contend> getContendList( );

}