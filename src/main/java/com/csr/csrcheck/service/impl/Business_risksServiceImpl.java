package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Business_risksMapper;
import com.csr.csrcheck.mapper.LawsuitMapper;
import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.Business_risksService;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.ex.LawsuitException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Business_risksServiceImpl implements Business_risksService {
    @Resource
    private Business_risksMapper business_risksMapper;



    @Override
    public List<Business_risks> getBusiness_riskslist() {
        List<Business_risks> list=business_risksMapper.getBusiness_riskslist();
        if(list==null){
            throw new LawsuitException("经营风险不存在");
        }
        return list;
    }
}
