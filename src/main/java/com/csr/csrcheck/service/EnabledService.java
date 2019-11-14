package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Enabled;
import com.csr.csrcheck.pojo.Speech;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface EnabledService {

    //查询药企产业链生态圈赋能信息
    public List<Enabled> getEnabledList();


    /**
     *根据药企名称分页查询药企产业链生态圈赋能信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum, int pageSize, String company_name);

}
