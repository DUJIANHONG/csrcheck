package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.EnabledMapper;
import com.csr.csrcheck.mapper.SpeechMapper;
import com.csr.csrcheck.pojo.Enabled;
import com.csr.csrcheck.pojo.Speech;
import com.csr.csrcheck.service.EnabledService;
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
public class EnabledServiceImpl implements EnabledService {
    @Resource
    private EnabledMapper enabledMapper;



    @Override
    public List<Enabled> getEnabledList() {
        List<Enabled> list=enabledMapper.getEnabledList();
        if(list==null){
            throw new ApprovalsException("药企产业链生态圈赋能信息数据不存在");
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
    private PageInfo<Enabled> getPageInfo(int pageNum, int pageSize, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Enabled> list =enabledMapper.getEnabledListpage(company_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
