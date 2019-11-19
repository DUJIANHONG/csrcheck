package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Product_typeMapper;
import com.csr.csrcheck.pojo.Product_type;
import com.csr.csrcheck.service.Product_typeService;
import com.csr.csrcheck.service.ex.CompanyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 10:44
 * @version:
 * @modified By:
 */
@Service
public class Product_typeServiceImpl implements Product_typeService {

    @Resource
    private Product_typeMapper productTypeMapper;

    @Override
    public List<Product_type> getlist() {
        List<Product_type> list=productTypeMapper.getlist();
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
    }
}
