package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Approved_byMapper;
import com.csr.csrcheck.pojo.Approved_by;
import com.csr.csrcheck.service.Approved_byService;
import com.csr.csrcheck.service.ex.CompanyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/18 15:47
 * @version:
 * @modified By:
 */
@Service
public class Approved_byServiceImpl implements Approved_byService {

    @Resource
    private Approved_byMapper approved_byMapper;

    /**
     *查询准字
     *  @return
     */
    @Override
    public List<Approved_by> listApprovde_by() {
        List list=approved_byMapper.listApprovde_by();
        if(list==null){
            throw  new CompanyException("数据为空");
        }
        return list;
    }
}
