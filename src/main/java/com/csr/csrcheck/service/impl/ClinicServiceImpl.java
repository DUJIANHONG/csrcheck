package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.CompanyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Resource
    private ClinicMapper clinicMapper;
    @Override
    public List<Clinic> getCliniclist() {
        List<Clinic> list=clinicMapper.getCliniclist();
        if(list==null){
            throw new ClinicException("临床数据不存在");
        }
        return list;
    }
}
