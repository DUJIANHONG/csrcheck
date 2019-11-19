package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.IndustryMapper;
import com.csr.csrcheck.mapper.ResearchMapper;
import com.csr.csrcheck.pojo.Industry;
import com.csr.csrcheck.pojo.Research;
import com.csr.csrcheck.service.IndustryService;
import com.csr.csrcheck.service.ResearchService;
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
public class IndustryServiceImpl implements IndustryService {
    @Resource
    private IndustryMapper industryMapper;

    @Override
    public List<Industry> getIndustryList() {
        List<Industry> list=industryMapper.getIndustryList();
        if(list==null){
            throw new ApprovalsException("专业行业信息数据不存在");
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
    private PageInfo<Industry> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Industry> list =industryMapper.getIndustryListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
