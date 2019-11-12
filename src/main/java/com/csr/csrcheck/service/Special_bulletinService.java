package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 11:05
 * @version:
 * @modified By:
 */
public interface Special_bulletinService {

    /**
     * 根据企业名称和发布时间查询企业特别公告
     * @param release_time
     * @param company_name
     * @return
     */
    public PageResult getlistpage(String release_time,
                                  String  company_name,int pageNum,int pageSize);
}
