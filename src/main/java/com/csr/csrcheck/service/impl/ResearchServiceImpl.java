package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.GuideMapper;
import com.csr.csrcheck.mapper.ResearchMapper;
import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.pojo.Research;
import com.csr.csrcheck.service.GuideService;
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
public class ResearchServiceImpl implements ResearchService {
    @Resource
    private ResearchMapper researchMapper;






    @Override
    public List<Research> getResearchList() {
        List<Research> list=researchMapper.getResearchList();
        if(list==null){
            throw new ApprovalsException("药企信用研究信息数据不存在");
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
    private PageInfo<Research> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Research> list =researchMapper.getResearchListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
