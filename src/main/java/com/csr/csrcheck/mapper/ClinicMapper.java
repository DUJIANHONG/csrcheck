package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;

import java.util.List;

public interface ClinicMapper {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Clinic> getCliniclist( );
}
