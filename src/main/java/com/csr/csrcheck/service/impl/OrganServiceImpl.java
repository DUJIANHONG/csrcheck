package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.mapper.OrganMapper;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.OrganService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.CompanyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrganServiceImpl implements OrganService {
    @Resource
    private OrganMapper organMapper;


    @Override
    public List<Company> getOrganlist() {
        List<Company> list=organMapper.getOrganlist();
        if(list==null){
            throw new CompanyException("前十大投资机构数据不存在");
        }
        return list;
    }

    @Override
    public List<Company> getOrganlist2() {
        List<Company> list=organMapper.getOrganlist2();
        if(list==null){
            throw new CompanyException("基本信息不存在");
        }
        return list;
    }
}
