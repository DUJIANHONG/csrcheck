package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.CompanyMapper;
import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

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
        if (company_name == null || company_name.equals("")){
            throw new CompanyException("请输入公司名称");
        }
        if (list==null){
            throw new CompanyException("数据不存在");
        }
        if (company_name.equals("")|| company_name==null){
            throw new CompanyException("请输入公司名称");
        }
        return list;
    }

    @Override
    public PageResult findPage(int pageNum,int pageSize,String company_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageinfo(pageNum,pageSize,company_name));
    }

    @Override
    public List<Company> getCommpanylistpage(String company_name, Integer currentPageNo, Integer pageSize) {
        List<Company> list=companyMapper.getCommpanylistpage(company_name,(currentPageNo-1)*pageSize,pageSize);
       if(list==null){
           throw new CompanyException("没有数据");
       }
        return list;
    }

    @Override
    public int getCompanyCount(String company_name) {
        int count=companyMapper.getCompanyCount(company_name);
        return count;
    }



    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<Company> getPageinfo(int pageNum,int pageSize,String company_name){
        PageHelper.startPage(pageNum, pageSize);
        List<Company> companyList=companyMapper.getCompanyPage(company_name);
        return new PageInfo<Company>(companyList);
    }

    @Override
    public List<Special_bulletin> getAll() {
        return companyMapper.getAll()   ;
    }

}
