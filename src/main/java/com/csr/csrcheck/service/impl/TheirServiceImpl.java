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
    public List<Product> getAlltheirByproduct_id(int id) {
        return theirMapper.getAlltheirByproduct_id(id);
    }
}
