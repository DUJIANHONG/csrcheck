package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Flight_checkMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.Flight_checkException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Flight_checkServiceImpl implements IFlight_checkService {
    @Resource
    private Flight_checkMapper flight_checkMapper;
    @Override
    public List<Flight_check> getFlight_checklist() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist();
        if(list==null){
            throw new Flight_checkException("药企中的数据不存在");
        }
        return list;
    }

    @Override
    public List<Flight_check> getFlight_checklist2() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist2();
        if(list==null){
            throw new Flight_checkException("化妆品中的数据不存在");
        }
        return list;
    }

    @Override
    public List<Flight_check> getFlight_checklist3() {
        List<Flight_check> list=flight_checkMapper.getFlight_checklist3();
        if(list==null){
            throw new Flight_checkException("化妆品中的数据不存在");
        }
        return list;
    }


}
