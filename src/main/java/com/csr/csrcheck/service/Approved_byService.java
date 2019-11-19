package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Approved_by;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/18 15:46
 * @version:
 * @modified By:
 */
public interface Approved_byService {

    /**
     *查询产品准字
     *  @return
     */
    public List<Approved_by> listApprovde_by();
}
