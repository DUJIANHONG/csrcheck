package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Evaluate;

import java.util.List;

/**
 * 查药企中一致性评价的接口
 */
public interface EvaluateMapper {
    /**
     * 查询一致性评价信息
     * @param
     * @return
     */
    public List<Evaluate> getEvaluatelist( );
}
