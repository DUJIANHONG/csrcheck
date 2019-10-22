package com.csr.csrcheck.service;


import com.csr.csrcheck.pojo.Evaluate;

import java.util.List;

public interface EvaluateService {
    /**
     * 查询一致性评价信息
     * @param
     * @return
     */
    public List<Evaluate> getEvaluatelist( );
}
