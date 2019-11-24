package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ShareholderMapper;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.service.ShareholderService;
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
 * @date: Created in 2019/11/12 10:37
 * @version:
 * @modified By:
 */
@Service
public class ShareholderServiceImpl implements ShareholderService {

    @Resource
    private ShareholderMapper shareholderMapper;
    /**
     * 根据公司名称、股东名称，股份类型分页查询
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @return
     */
    @Override
    public PageResult getListPage(int pageNum,int pageSize,String shareholder_name, String share_type, String company_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,shareholder_name,share_type,company_name));
    }

    @Override
    public void addShareholder(Shareholder shareholder) {
        int row=shareholderMapper.addShareholder(shareholder);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
    }

    @Override
    public List<Shareholder> list() {
        List list=shareholderMapper.list();
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
    }

    @Override
    public int updateShareholder(Shareholder shareholder) {
        int row =shareholderMapper.updateShareholder(shareholder);
        if (row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public Shareholder findshareholderByid(int id) {
        Shareholder list=shareholderMapper.findshareholderByid(id);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return list;
    }

    @Override
    public int deleteshareholderByid(int id) {
        int row=shareholderMapper.deleteshareholderByid(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param shareholder_name
     * @param share_type
     * @param company_name
     * @return
     */
    private PageInfo<Shareholder> getPageInfo(int pageNum,int pageSize,String shareholder_name, String share_type, String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Shareholder> list =shareholderMapper.getListPage(shareholder_name,share_type,company_name);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<>(list);
    }
}
