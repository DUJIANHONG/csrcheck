package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;

import java.util.List;

public interface ClinicService {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Clinic> getCliniclist( );
}
