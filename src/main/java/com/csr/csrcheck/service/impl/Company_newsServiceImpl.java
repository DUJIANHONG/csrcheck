package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Company_newsMapper;
import com.csr.csrcheck.pojo.Company_news;
import com.csr.csrcheck.service.Company_newsAService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-11-14 10:26
 */
@Service
public class Company_newsServiceImpl implements Company_newsAService {
    @Resource
    private Company_newsMapper company_newsMapper;
    @Override
    public List<Company_news> selectAllBycompany_id(int company_id) {
        return company_newsMapper.selectAllBycompany_id(company_id);
    }
}
