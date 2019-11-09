package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;

import java.util.List;

public interface Instrument_bulletinMapper {
    /**
     * 查询临床信息
     * @param
     * @return
     */
    public List<Clinic> getCliniclist();
}
