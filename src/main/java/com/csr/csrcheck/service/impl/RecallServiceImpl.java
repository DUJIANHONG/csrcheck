package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.RecallMapper;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.service.RecallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:48
 */
@Service
public class RecallServiceImpl implements RecallService {
    @Resource
    private RecallMapper recallMapper;

    @Override
    public List<Product_recall> getlist() {
        return recallMapper.getlist();
    }
}
