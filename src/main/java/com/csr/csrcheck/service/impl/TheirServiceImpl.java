package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.TheirMapper;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.TheirService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getAlltheirByproduct_id(int id,String product_name) {
        return theirMapper.getAlltheirByproduct_id(id,product_name);
    }

    @Override
    public List<Product> gettheirByimport(int t_id, int i_id) {
        return theirMapper.gettheirByimport(t_id,i_id);
    }

    @Override
    public List<Product> getComanyByProduct_t_id(int t_id) {
        return theirMapper.getComanyByProduct_t_id(t_id);
    }
}
