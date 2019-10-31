package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ProductMapper;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ProductService;

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

    @Override
    public PageResult listpage(int pageNum, int pageSize, String product_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getpageinfo(pageNum,pageSize,product_name));
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    private PageInfo getpageinfo(int pageNum, int pageSize, String product_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Product> list=productMapper.listpage(product_name);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<Product>(list);
    }

}
