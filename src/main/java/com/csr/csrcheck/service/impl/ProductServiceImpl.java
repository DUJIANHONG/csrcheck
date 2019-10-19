package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ProductMapper;

import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ProductService;

import com.csr.csrcheck.service.ex.ProductException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Override
    public List<Product> getProductlist() {
        List<Product> list=productMapper.getProductlist();
        if(list==null){
            throw new ProductException("产品数据不存在");
        }
        return list;
    }

    @Override
    public List<Product> getProductlistbyname(String product_name) {
        List<Product> list=productMapper.getProductlistbyname(product_name);
        if (list==null){
            throw new ProductException("产品数据不存在");
        }
        return list;
    }
}
