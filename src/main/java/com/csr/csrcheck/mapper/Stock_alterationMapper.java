package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.pojo.Stock_alteration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 11:28
 * @version:
 * @modified By:
 */
public interface Stock_alterationMapper {

    /**
     *根据股东名称、股东类型，变更时间查询
     *  @param shareholder_name
     * @param type
     * @param change_time
     * @return
     */
    public List<Stock_alteration> getlistPage(@Param(value = "shareholder_name") String shareholder_name,
                                              @Param(value = "type") String  type,
                                              @Param(value = "change_time") String change_time);

    /**
     * 增加股权变更信息
     * @param stock_alteration
     * @return
     */
    public int addStock_alteration(Stock_alteration stock_alteration);

    /**
     * 修改股权变更信息
     * @param stock_alteration
     * @return
     */
    int updateStock_alteration(Stock_alteration stock_alteration);

    /**
     * 根据id查找股权变更
     * @param id
     * @return
     */
    Stock_alteration findstock_alterationByid(int id);

    /**
     *根据id删除股权变更
     *  @param id
     * @return
     */
    int deletestock_alterationByid(int id);
}
