package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Lawsuit;

import java.util.List;

public interface LawsuitService {
    /**
     * 查询法律诉讼
     * @param
     * @return
     */
    public List<Lawsuit> getLawsuitlist();
}
