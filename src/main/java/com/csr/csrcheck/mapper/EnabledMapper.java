package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Enabled;
import com.csr.csrcheck.pojo.Speech;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface EnabledMapper {

    //查询药企产业链生态圈赋能信息
    public List<Enabled> getEnabledList();

    /**
     *根据公司名查询药企产业链生态圈赋能信息
     *  @param company_name
     * @return
     */
    public List<Enabled> getEnabledListpage(@Param(value = "company_name") String company_name);

}
