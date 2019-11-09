package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ProductMapper;
import com.csr.csrcheck.mapper.Product_apparatusMapper;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.service.Product_apparatusService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.ProductException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Product_apparatusServiceImpl implements Product_apparatusService {
    @Resource
    private Product_apparatusMapper product_apparatusMapper;



    @Override
    public List<Product> getProductlistbyname(String product_name) {
        List<Product> list = product_apparatusMapper.getProductlistbyname(product_name);
        if (list == null) {
            throw new ProductException("医疗器械数据不存在");

        }
       /* if (product_name.equals("") || product_name == null) {
            throw new ProductException("请输入产品名称");
        }*/
        return list;
    }
}
