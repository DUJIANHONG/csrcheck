package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Product;

import java.util.List;

public interface Actual_controllerService {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Actual_controller> getActual_controllerlist( );
    /**
     *查询id和名称
     *  @return
     */
    List<Actual_controller> list();
}
