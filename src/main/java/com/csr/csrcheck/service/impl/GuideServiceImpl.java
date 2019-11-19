package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ContendMapper;
import com.csr.csrcheck.mapper.GuideMapper;
import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.service.ContendService;
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
public class GuideServiceImpl implements GuideService {
    @Resource
    private GuideMapper guideMapper;




    @Override
    public List<Guide> getGuideList() {
        List<Guide> list=guideMapper.getGuideList();
        if(list==null){
            throw new ApprovalsException("行业指导药企CSR指南信息数据不存在");
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
    private PageInfo<Guide> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Guide> list =guideMapper.getGuideListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
