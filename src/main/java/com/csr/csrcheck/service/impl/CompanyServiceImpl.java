package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.CompanyMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageRequest;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:24
 * @version:
 * @modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Override
    public List<Company> getCommpanylist() {
     List<Company> list=companyMapper.getCommpanylist();
     if(list==null){
       throw new CompanyException("数据不存在");
     }
        return list;
    }

    @Override
    public List<Company> getCommpanylistbyname(String company_name){
        List<Company> list=companyMapper.getCommpanylistbyname(company_name);
        Company company=new Company();
        if (list==null){
            throw new CompanyException("数据不存在");
        }
        return list;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageinfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Company> getPageinfo(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(1, 6);
        List<Company> companyList=companyMapper.getCompanyPage();
        return new PageInfo<Company>(companyList);
    }

}
