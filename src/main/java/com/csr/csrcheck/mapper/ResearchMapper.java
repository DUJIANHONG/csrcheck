package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.pojo.Research;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface ResearchMapper {

    //查询药企信用研究信息
    public List<Research> getResearchList();

    /**
     *根据药企查询信用研究信息
     *  @param company_name
     * @return
     */
    public List<Research> getResearchListpage(@Param(value = "company_name") String company_name);

}
