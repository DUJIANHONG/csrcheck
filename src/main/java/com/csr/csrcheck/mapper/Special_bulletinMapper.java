package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Special_bulletin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 10:57
 * @version:
 * @modified By:
 */
public interface Special_bulletinMapper {

    /**
     * 根据企业名称和发布时间查询企业特别公告
     * @param release_time
     * @param company_name
     * @return
     */
    public List<Special_bulletin> getlistpage(@Param(value = "release_time") String release_time,
                                              @Param(value = "company_name") String  company_name);
}
