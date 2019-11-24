package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/12 11:05
 * @version:
 * @modified By:
 */
public interface Special_bulletinService {

    /**
     * 根据企业名称和发布时间查询企业特别公告
     * @param release_time
     * @param company_name
     * @return
     */
    public PageResult getlistpage(String release_time,
                                  String  company_name,int pageNum,int pageSize);
    /**
     * 增加特别公告信息
     * @param special_bulletin
     */
    public void addSpecial_bulletin(Special_bulletin special_bulletin);

    /**
     * 修改特别公告
     * @param special_bulletin
     * @return
     */
    int updateSpecial_bulletin(Special_bulletin special_bulletin);
    /**
     * 根据id查找特别公告
     * @param id
     * @return
     */
    Special_bulletin findspecial_bulletinByid(int id);
    /**
     *根据id删除特别公告
     *  @param id
     * @return
     */
    int deletespecial_bulletinByid(int id);
}
