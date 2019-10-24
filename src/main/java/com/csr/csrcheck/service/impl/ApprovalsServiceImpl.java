package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ApprovalsMapper;
import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.service.ApprovalsService;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.ApprovalsException;
import com.csr.csrcheck.service.ex.ClinicException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApprovalsServiceImpl implements ApprovalsService {
    @Resource
    private ApprovalsMapper approvalsMapper;

    @Override
    public List<Approvals> getApprovalslist() {
        List<Approvals> list=approvalsMapper.getApprovalslist();
        if(list==null){
            throw new ApprovalsException("临床数据不存在");
        }
        return list;
    }
}
