package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.ClinicMapper;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Resource
    private ClinicMapper clinicMapper;
    @Override
    public List<Clinic> getCliniclist() {
        List<Clinic> list=clinicMapper.getCliniclist();
        if(list==null){
            throw new ClinicException("临床数据不存在");
        }
        return list;
    }

    @Override
    public PageResult getListpage(int pageNum, int pageSize, String product_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,product_name));
    }


    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    private PageInfo<Clinic> getPageInfo(int pageNum,int pageSize,String product_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Clinic> list=clinicMapper.getCliniclistpage(product_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
     /*   if(product_name==null || product_name.equals("")){
            throw new CompanyException("请输入药品名称");
        }*/
        return new PageInfo<>(list);
    }
}
