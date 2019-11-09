package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.MilitaryMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.MilitaryService;
import com.csr.csrcheck.service.ex.ClinicException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MilitaryServiceImpl implements MilitaryService {
    @Resource
    private MilitaryMapper militaryMapper;
    @Override
    public List<Product> getMilitarylist() {
        List<Product> list=militaryMapper.getMilitarylist();
        if(list==null){
            throw new ClinicException("国产不存在");
        }
        return list;
    }

    @Override
    public List<Product> getMilitarylist2() {
        List<Product> list=militaryMapper.getMilitarylist2();
        if(list==null){
            throw new ClinicException("进口不存在");
        }
        return list;
    }

    @Override
    public List<Product> getAllLegitimate_producers(int product_t_id) {
        return militaryMapper.getAllLegitimate_producers(product_t_id);
    }

    @Override
    public List<Abnormal_products> getAllabnormal_products(int product_t_id) {
        return militaryMapper.getAllabnormal_products(product_t_id);
    }
}
