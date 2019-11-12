package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Shareholder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 10:26
 * @version:
 * @modified By:
 */
public interface ShareholderMapper {

    /**
     * 根据公司名称、股东名称，股份类型分页查询
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @return
     */
    public List<Shareholder> getListPage(@Param(value = "shareholder_name") String shareholder_name,
                                         @Param(value = "share_type") String share_type,
                                         @Param(value = "company_name") String company_name);
}
