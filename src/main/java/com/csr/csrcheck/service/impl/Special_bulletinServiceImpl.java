package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Special_bulletinMapper;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.service.Special_bulletinService;
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
 * @date: Created in 2019/11/12 11:07
 * @version:
 * @modified By:
 */
@Service
public class Special_bulletinServiceImpl implements Special_bulletinService {

    @Resource
    private Special_bulletinMapper special_bulletinMapper;
    /**
     *根据企业名称和发布时间查询企业特别公告
     *  @param release_time
     * @param company_name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult getlistpage(String release_time, String company_name, int pageNum, int pageSize) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(release_time,company_name,pageNum,pageSize));
    }

    @Override
    public void addSpecial_bulletin(Special_bulletin special_bulletin) {
        int row=special_bulletinMapper.addSpecial_bulletin(special_bulletin);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
    }

    @Override
    public int updateSpecial_bulletin(Special_bulletin special_bulletin) {
        int row =special_bulletinMapper.updateSpecial_bulletin(special_bulletin);
        if (row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public Special_bulletin findspecial_bulletinByid(int id) {
        Special_bulletin list = special_bulletinMapper.findspecial_bulletinByid(id);
        if (list == null) {
            throw new CompanyException("数据为空");
        }
        return list;
    }

    @Override
    public int deletespecial_bulletinByid(int id) {
        int row=special_bulletinMapper.deletespecial_bulletinByid(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    /**
     *调用分页插件完成分页
     *  @param release_time
     * @param company_name
     * @param pageNum
     * @param pageSize
     * @return
     */
    private PageInfo<Special_bulletin> getPageInfo(String release_time, String company_name, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Special_bulletin> list=special_bulletinMapper.getlistpage(release_time, company_name);
        if (list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
