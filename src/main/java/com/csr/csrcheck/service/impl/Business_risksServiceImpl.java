package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Business_risksMapper;
import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Risk_classify;
import com.csr.csrcheck.pojo.Risk_type;
import com.csr.csrcheck.service.Business_risksService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.LawsuitException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Business_risksServiceImpl implements Business_risksService {
    @Resource
    private Business_risksMapper business_risksMapper;



    @Override
    public List<Business_risks> getBusiness_riskslist() {
        List<Business_risks> list=business_risksMapper.getBusiness_riskslist();
        if(list==null){
            throw new LawsuitException("经营风险不存在");
        }
        return list;
    }

    @Override
    public PageResult getListpage(int pageNum, int pageSize, String company_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name));
    }

    /**
     * 增加
     * @param business_risks
     */
    @Override
    public void addBusiness(Business_risks business_risks) {
        int row=business_risksMapper.addBusiness(business_risks);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
    }

    /**
     *修改
     *  @param business_risks
     * @return
     */
    @Override
    public int updateBusiness(Business_risks business_risks) {
        int row = business_risksMapper.updateBusiness(business_risks);
        if(row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    /**
     *删除
     *  @param id
     * @return
     */
    @Override
    public int deleteBusiness(int id) {
        int row=business_risksMapper.deleteBusiness(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    @Override
    public List<Risk_classify> findbylistclassify() {
        return business_risksMapper.findbylistclassify();
    }

    @Override
    public List<Risk_type> findbylisttype() {
        return business_risksMapper.findbylisttype();
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    private PageInfo<Business_risks> getPageInfo(int pageNum,int pageSize,String company_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Business_risks> list=business_risksMapper.getListpage(company_name);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<Business_risks>(list);
    }
}
