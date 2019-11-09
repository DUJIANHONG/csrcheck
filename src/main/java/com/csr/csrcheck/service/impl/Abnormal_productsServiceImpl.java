package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Abnormal_productsMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.service.Abnormal_productsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-25 17:16
 */
@Service
public class Abnormal_productsServiceImpl implements Abnormal_productsService {
    @Resource
    private Abnormal_productsMapper abnormal_productsMapper;

    @Override
    public List<Abnormal_products> getAllProduct() {
        return abnormal_productsMapper.getAllProduct();
    }
}
