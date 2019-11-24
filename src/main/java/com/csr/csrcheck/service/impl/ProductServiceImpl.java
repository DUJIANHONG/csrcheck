package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ProductMapper;
import com.csr.csrcheck.pojo.*;
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

    @Override
    public List<Product> list() {
        List list=productMapper.list();
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
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

    @Override
    public List<Product_type> selectProduct_type() {
        return productMapper.selectProduct_type();
    }

    @Override
    public List<Patent_type> selectPatent() {
        return productMapper.selectPatent();
    }

    @Override
    public List<Company> selectCompany() {
        return productMapper.selectCompany();
    }

    @Override
    public List<Stage> selectStage() {
        return productMapper.selectStage();
    }

    @Override
    public int addproduct(Product product) {
        return productMapper.addproduct(product);
    }

    @Override
    public Product selectByproduct_id(int product_id) {
        return productMapper.selectByproduct_id(product_id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }
}
