package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.mapper.EvaluateMapper;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.EvaluateService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.EvaluateException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;
    @Override
    public List<Evaluate> getEvaluatelist() {
        List<Evaluate> list=evaluateMapper.getEvaluatelist();
        if(list==null){
            throw new EvaluateException("临床数据不存在");
        }
        return list;
    }
}
