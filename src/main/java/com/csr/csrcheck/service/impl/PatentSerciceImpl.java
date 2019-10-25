package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.PatentMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Patent;
import com.csr.csrcheck.service.PatentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 14:00
 */
@Service
public class PatentSerciceImpl implements PatentService {
    @Resource
    private PatentMapper patentMapper;
    @Override
    public List<Patent> getListByProduct(int company_id) {
        List<Patent> list = patentMapper.getListByProduct(company_id);
        return list;
    }
}
