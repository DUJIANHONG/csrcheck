package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.util.PageResult;


import java.util.List;

public interface ApprovalsService {
    /**
     * 查询批文信息
     * @paramreturn
     */
    public List<Approvals> getApprovalslist( );

    /**
     *根据产品名称查询批文信息&分页查询
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    public PageResult getApprovalslistpage(int pageNum,int pageSize,String product_name);

    /**
     * 增加批文
     * @param approvals
     */
    public void addApprovals(Approvals approvals);
}
