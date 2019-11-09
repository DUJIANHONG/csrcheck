package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Lawsuit;

import java.util.List;

public interface LawsuitMapper {
    /**
     * 查询法律诉讼
     * @param
     * @return
     */
    public List<Lawsuit> getLawsuitlist();
}
