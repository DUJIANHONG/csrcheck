package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.LawsuitMapper;
import com.csr.csrcheck.mapper.OrganMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.OrganService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.LawsuitException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LawsuitServiceImpl implements LawsuitService {
    @Resource
    private LawsuitMapper lawsuitMapper;




    @Override
    public List<Lawsuit> getLawsuitlist() {
        List<Lawsuit> list=lawsuitMapper.getLawsuitlist();
        if(list==null){
            throw new LawsuitException("法律诉讼不存在");
        }
        return list;
    }
}
