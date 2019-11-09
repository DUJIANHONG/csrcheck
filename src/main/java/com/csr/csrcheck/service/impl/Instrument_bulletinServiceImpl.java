package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.mapper.Instrument_bulletinMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.Instrument_bulletinService;
import com.csr.csrcheck.service.ex.ClinicException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Instrument_bulletinServiceImpl implements Instrument_bulletinService {
    @Resource
    private Instrument_bulletinMapper instrument_bulletinMapper;
    @Override
    public List<Important_notification> getImportant_notificationlist() {
        List<Important_notification> list=instrument_bulletinMapper.getImportant_notificationlist();
        if(list==null){
            throw new ClinicException("医疗器械重要通报数据不存在");
        }
        return list;
    }

    @Override
    public List<Abnormal_products> getAbnormal_productslist() {
        List<Abnormal_products> list=instrument_bulletinMapper.getAbnormal_productslist();
        if(list==null){
            throw new ClinicException("医疗器械不合格通报数据不存在");
        }
        return list;
    }
}
