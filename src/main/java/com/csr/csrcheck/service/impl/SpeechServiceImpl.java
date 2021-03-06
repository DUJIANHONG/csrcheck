package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.OtherMapper;
import com.csr.csrcheck.mapper.SpeechMapper;
import com.csr.csrcheck.pojo.Other;
import com.csr.csrcheck.pojo.Speech;
import com.csr.csrcheck.service.OtherService;
import com.csr.csrcheck.service.SpeechService;
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
public class SpeechServiceImpl implements SpeechService {
    @Resource
    private SpeechMapper speechMapper;



    @Override
    public List<Speech> getSpeechList() {
        List<Speech> list=speechMapper.getSpeechList();
        if(list==null){
            throw new ApprovalsException("社会责任报告撰写咨询信息数据不存在");
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
    private PageInfo<Speech> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Speech> list =speechMapper.getSpeechListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
