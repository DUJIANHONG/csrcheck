package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.PatentMapper;
import com.csr.csrcheck.pojo.Product;
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
    public List<Product> getListByProduct(int company_id) {
        List<Product> list = patentMapper.getListByProduct(company_id);
        return list;
    }
}
