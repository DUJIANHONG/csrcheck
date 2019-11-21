package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 10:36
 * @version:
 * @modified By:
 */
public interface ShareholderService {

    /**
     * 根据公司名称、股东名称，股份类型分页查询
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @return
     */
    public PageResult getListPage( int pageNum,int pageSize,String shareholder_name,
                                   String share_type,
                                   String company_name);
    /**
     * 增加股东信息
     * @param shareholder
     */
    public void addShareholder(Shareholder shareholder);

    /**
     *查询产品id和产品名称
     *  @return
     */
    List<Shareholder> list();

    /**
     * 修改股东
     * @param shareholder
     * @return
     */
    int updateShareholder(Shareholder shareholder);
    /**
     * 根据id查找股东
     * @param id
     * @return
     */
    Shareholder findshareholderByid(int id);
    /**
     *根据id删除股东
     *  @param id
     * @return
     */
    int deleteshareholderByid(int id);
}
