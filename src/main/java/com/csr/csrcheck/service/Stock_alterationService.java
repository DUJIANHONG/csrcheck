package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 11:39
 * @version:
 * @modified By:
 */
public interface Stock_alterationService {

    /**
     *根据股东名称、股东类型，变更时间查询
     *  @param shareholder_name
     * @param type
     * @param change_time
     * @return
     */
    public PageResult getlistPage(int pageNum,int pageSize,String shareholder_name,
                                  String  type,
                                  String change_time);
}
