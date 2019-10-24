package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Approvals;


import java.util.List;

public interface ApprovalsService {
    /**
     * 查询批文信息
     * @paramreturn
     */
    public List<Approvals> getApprovalslist( );
}
