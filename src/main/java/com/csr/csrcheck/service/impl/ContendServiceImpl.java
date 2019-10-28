package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ContendMapper;
import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Contend;

import com.csr.csrcheck.service.ContendService;
import com.csr.csrcheck.service.ex.ApprovalsException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContendServiceImpl implements ContendService {
    @Resource
    private ContendMapper contendMapper;


    @Override
    public List<Contend> getContendList() {
        List<Contend> list=contendMapper.getContendList();
        if(list==null){
            throw new ApprovalsException("药企核心竞争力动态信息数据不存在");
        }
        return list;
    }
}
