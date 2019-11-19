package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.EcosphereMapper;
import com.csr.csrcheck.pojo.Five_supplier;
import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.service.EcosphereSrevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-31 17:29
 */
@Service
public class EcosphereSreviceImpl implements EcosphereSrevice {
    @Resource
    private EcosphereMapper ecosphereMapper;
    @Override
    public List<Five_supplier> getAllSupplier(int company_id) {
        return ecosphereMapper.getAllSupplier(company_id);
    }

    @Override
    public List<Stock_alteration> getAllAlteration(int company_id) {
        return ecosphereMapper.getAllAlteration(company_id);
    }
}
