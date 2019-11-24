package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Evaluate;
import org.apache.ibatis.annotations.Param;

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
    public List<Evaluate> getEvaluatelist();

    /**
     * 根据企业名称或者产品名称查询一致性评价信息
     * @param company_name
     * @param product_name
     * @return
     */
    public List<Evaluate> getEvaluatepage(@Param(value = "company_name") String company_name,
                                          @Param(value = "product_name") String product_name);

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
