package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.pojo.Guide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface GuideMapper {

    //查询药企指南信息
    public List<Guide> getGuideList();

    /**
     *根据药企查询药企指南信息
     *  @param company_name
     * @return
     */
    public List<Guide> getGuideListpage(@Param(value = "company_name") String company_name);

}
