package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.util.PageResult;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 13:59
 */

public interface ContendService {

    //查询药企核心竞争力动态信息
    public List<Contend> getContendList( );


    /**
     *根据药企名称分页查询药企核心竞争力动态信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    PageResult getListpage(int pageNum,int pageSize,String company_name);

    /**
     * 增加核心竞争力
     * @param contend
     * @return
     */
    int addcontend(Contend contend);

    /**
     * 修改核心竞争力
     * @param contend
     * @return
     */
    int updatecontend(Contend contend);

    /**
     *删除核心竞争力
     *  @param id
     * @return
     */
    int deletecontend(int id);

    /**
     * 根据id查询核心竞争力
     * @param id
     * @return
     */
    public Contend findcontendByid(int id);

}
