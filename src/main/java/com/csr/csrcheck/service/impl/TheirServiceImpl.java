package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.TheirMapper;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.TheirService;
import com.csr.csrcheck.service.ex.ProductException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 15:10
 */
@Service
public class TheirServiceImpl implements TheirService {

    @Resource
    private TheirMapper theirMapper;

    @Override
    public List<Product> getAlltheirByproduct_name(String product_name) {
        List<Product> list = theirMapper.getAlltheirByproduct_name(product_name);
        if (product_name == null || product_name.equals("")){
            throw new ProductException("请输入产品名称");
        }
        if (list == null){
            throw new ProductException("没有数据");
        }
        return list;
    }

    @Override
    public List<Product> gettheirByimport(int t_id, int i_id) {
        List<Product> list = theirMapper.gettheirByimport(t_id,i_id);


        if (list==null){
            throw new ProductException("没有数据");
        }
        return list;
    }
    @Override
    public List<Product> getComanyByProduct_t_id(int t_id) {
        return theirMapper.getComanyByProduct_t_id(t_id);
    }

    @Override
    public List<Important_notification> getAllNotification() {
        return theirMapper.getAllNotification();
    }
}
