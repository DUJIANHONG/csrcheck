package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Approvals;

import java.util.List;

/**
 * 查药企中的批文的接口
 */
public interface ApprovalsMapper {
    /**
     * 查询批文信息
     * @paramreturn
     */
    public List<Approvals> getApprovalslist( );

    /**
     * 根据产品名称分页 查询批文
     * @param name
     * @return
     */
    public List<Approvals> getapprovalspage(String name);
}
