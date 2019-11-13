package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ShareholderMapper;
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
