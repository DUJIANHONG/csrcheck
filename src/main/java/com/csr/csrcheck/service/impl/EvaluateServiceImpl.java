package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.EvaluateMapper;
import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.service.EvaluateService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.EvaluateException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;
    @Override
    public List<Evaluate> getEvaluatelist() {
        List<Evaluate> list=evaluateMapper.getEvaluatelist();
        if(list==null){
            throw new EvaluateException("临床数据不存在");
        }
        return list;
    }

    @Override
    public PageResult getlistpage(int pageNum, int pageSize, String company_name,String product_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name,product_name));
    }

    @Override
    public int addevlaute(Evaluate evaluate) {
        int row=evaluateMapper.addevlaute(evaluate);
        if(row!=1){
            throw new CompanyException("增加失败");
        }
        return row;
    }

    @Override
    public int updateevlaute(Evaluate evaluate) {
        int row=evaluateMapper.updateevlaute(evaluate);
        if(row!=1){
            throw new CompanyException("修改失败");
        }
        return row;
    }

    @Override
    public int deleteevlaute(int id) {
        int row=evaluateMapper.deleteevlaute(id);
        if(row!=1){
            throw new CompanyException("删除失败");
        }
        return row;
    }

    @Override
    public Evaluate findevluateByid(int id) {
        return evaluateMapper.findevluateByid(id);
    }

    /**
     *调用分页插件完成分页
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @return
     */
    private PageInfo<Evaluate> getPageInfo(int pageNum,int pageSize,String company_name,String product_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Evaluate> list=evaluateMapper.getEvaluatepage(company_name,product_name);
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new PageInfo<>(list);
    }
}
