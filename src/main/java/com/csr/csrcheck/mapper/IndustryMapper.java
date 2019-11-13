package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Industry;
import com.csr.csrcheck.pojo.Research;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface IndustryMapper {

    //查询专业行业信息
    public List<Industry> getIndustryList();

    /**
     *根据专业行业信息
     *  @param company_name
     * @return
     */
    public List<Industry> getIndustryListpage(@Param(value = "company_name") String company_name);

}
