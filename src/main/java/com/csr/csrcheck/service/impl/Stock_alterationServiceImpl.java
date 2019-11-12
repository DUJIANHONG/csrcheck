package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Stock_alterationMapper;
import com.csr.csrcheck.pojo.Shareholder;
import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.service.Stock_alterationService;
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
 * @date: Created in 2019/11/12 11:40
 * @version:
 * @modified By:
 */
@Service
public class Stock_alterationServiceImpl implements Stock_alterationService {

    @Resource
    private Stock_alterationMapper stock_alterationMapper;
    /**
     * 根据股东名称、股东类型，变更时间查询
     * @param pageNum
     * @param pageSize
     * @param shareholder_name
     * @param type
     * @param change_time
     * @return
     */
    @Override
    public PageResult getlistPage(int pageNum, int pageSize, String shareholder_name, String  type, String change_time) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,shareholder_name,type,change_time));
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param shareholder_name
     * @param type
     * @param change_time
     * @return
     */
    private PageInfo<Stock_alteration> getPageInfo(int pageNum, int pageSize, String shareholder_name, String  type, String change_time){
        PageHelper.startPage(pageNum,pageSize);
        List<Stock_alteration> list =stock_alterationMapper.getlistPage(shareholder_name,type,change_time);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<>(list);
    }
}
