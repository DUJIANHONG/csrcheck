package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Patent;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-21 9:33
 */
public interface PatentMapper {

    //查询該公司旗下的所有专利
    public List<Patent> getListByProduct(int company_id);

}
