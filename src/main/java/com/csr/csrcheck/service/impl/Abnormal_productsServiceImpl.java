package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Abnormal_productsMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.Abnormal_productsService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 11:11
 * @version:
 * @modified By:
 */
@Service
public class Abnormal_productsServiceImpl implements Abnormal_productsService {
    @Resource
    private Abnormal_productsMapper abnormal_productsMapper;

    public PageResult abnormallsitpage(int pageNum, int pageSize, String product_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,product_name));
    }

    @Override
    public List<Product> selectproduct() {
        return abnormal_productsMapper.selectproduct();
    }

    @Override
    public int addabnormal(Abnormal_products abnormal_products) {
        int result =abnormal_productsMapper.addabnormal(abnormal_products);
        if (result != 1){
            throw new CompanyException("添加失败！");
        }
        return result;
    }

    @Override
    public Abnormal_products selectByabnormal_id(int id) {
        return abnormal_productsMapper.selectByabnormal_id(id);
    }

    @Override
    public int updateabnormal(Abnormal_products abnormal_products) {
        int result = abnormal_productsMapper.updateabnormal(abnormal_products);
        if (result != 1){
            throw new CompanyException("修改失败");
        }
        return result;
    }

    @Override
    public int deleteabnormalByid(int id) {
        return abnormal_productsMapper.deleteabnormalByid(id);
    }


    private PageInfo getPageInfo(int pageNum,int pageSize,String product_name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Abnormal_products> list = abnormal_productsMapper.abnormallsit(product_name);
        if (list == null) {
            throw new CompanyException("没有数据");
        }
        return new PageInfo(list);
    }
    public List<Abnormal_products> getAbnormalByTheir_id(int product_type_id) {
        return abnormal_productsMapper.getAbnormalByTheir_id(product_type_id);
    }
}
