package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Actual_controllerMapper;
import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.service.Actual_controllerService;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.Actual_controllerException;
import com.csr.csrcheck.service.ex.ClinicException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Actual_controllerServiceImpl implements Actual_controllerService {
    @Resource
    private Actual_controllerMapper actual_controllerMapper;

    @Override
    public List<Actual_controller> getActual_controllerlist() {
        List<Actual_controller> list=actual_controllerMapper.getActual_controllerlist();
        if(list==null){
            throw new Actual_controllerException("核心人员关联企业数据不存在");
        }
        return list;
    }
}
