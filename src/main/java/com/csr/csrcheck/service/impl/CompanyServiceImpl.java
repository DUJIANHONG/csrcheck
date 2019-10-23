package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.CompanyMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ex.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:24
 * @version:
 * @modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Override
    public List<Company> getCommpanylist() {
     List<Company> list=companyMapper.getCommpanylist();
     if(list==null){
       throw new CompanyException("数据不存在");
     }
        return list;
    }

    @Override
    public List<Company> getCommpanylistbyname(String company_name){
        List<Company> list=companyMapper.getCommpanylistbyname(company_name);
        Company company=new Company();
        if (list==null){
            throw new CompanyException("数据不存在");
        }
        return list;
    }

    @Override
    public List<Company> getCommpanylistbynames(String company_name, Integer currentPageNo, Integer pageSize) {
       List<Company> list2=companyMapper.getCommpanylistbynames(company_name,currentPageNo,pageSize);
       if(list2==null){
           throw new CompanyException("数据不存在");
       }
        return list2;
    }

    @Override
    public Integer count(String company_name) {
        Integer compantcount=companyMapper.count(company_name);
        if(compantcount==0){
            throw new CompanyException("数量为0");
        }
        return compantcount;
    }
}
