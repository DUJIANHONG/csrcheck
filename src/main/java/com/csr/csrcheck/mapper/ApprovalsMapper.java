package com.csr.csrcheck.mapper;


import com.csr.csrcheck.pojo.Approvals;
import org.apache.ibatis.annotations.Param;

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
     * @param product_name
     * @return
     */
    public List<Approvals> getapprovalspage(@Param(value = "product_name") String product_name);


    /**
     * 增加批文
     * @param approvals
     * @return
     */
    public int addApprovals(Approvals approvals);

    /**
     * 修改批文
     * @param approvals
     * @return
     */
    int updateApprovals(Approvals approvals);

    /**
     * 根据id查找批文
     * @param id
     * @return
     */
    Approvals findapprovalsByid(int id);

    /**
     *根据id删除批文
     *  @param id
     * @return
     */
    int deleteapprovalsByid(int id);
}
