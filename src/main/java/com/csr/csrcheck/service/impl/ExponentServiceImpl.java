package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ExponentMapper;
import com.csr.csrcheck.mapper.GuideMapper;
import com.csr.csrcheck.pojo.Exponent;
import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.service.ExponentService;
import com.csr.csrcheck.service.GuideService;
import com.csr.csrcheck.service.ex.ApprovalsException;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExponentServiceImpl implements ExponentService {
    @Resource
    private ExponentMapper exponentMapper;

    @Override
    public List<Exponent> getExponentList() {
        List<Exponent> list=exponentMapper.getExponentList();
        if(list==null){
            throw new ApprovalsException("指数发布数据不存在");
        }
        return list;
    }

    @Override
    public PageResult getListpage(int pageNum, int pageSize, String company_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name));
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    private PageInfo<Exponent> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Exponent> list =exponentMapper.getExponentListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
