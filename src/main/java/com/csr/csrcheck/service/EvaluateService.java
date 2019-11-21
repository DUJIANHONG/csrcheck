package com.csr.csrcheck.service;


import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

public interface EvaluateService {
    /**
     * 查询一致性评价信息
     * @param
     * @return
     */
    public List<Evaluate> getEvaluatelist( );

    /**
     * 根据企业名称或者产品名称查询一致性评价信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @return
     */
    PageResult getlistpage(int pageNum,int pageSize,String company_name,String product_name);

    /**
     * 增加一致性评价
     * @param evaluate
     * @return
     */
    int addevlaute(Evaluate evaluate);

    /**
     *修改一致性评价
     *  @param evaluate
     * @return
     */
    int updateevlaute(Evaluate evaluate);

    /**
     *删除一致性评价
     *  @param id
     * @return
     */
    int deleteevlaute(int id);

    /**
     * 根据id查找一致性评价
     * @param id
     * @return
     */
    public Evaluate findevluateByid(int id);
}
