package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.RecallMapper;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.service.RecallService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:48
 */
@Service
public class RecallServiceImpl implements RecallService {
    @Resource
    private RecallMapper recallMapper;

    @Override
    public List<Product_recall> getlist() {
        return recallMapper.getlist();
    }

    /**
     *根据产品名称，产品类型名称，企业名称分页查询产品召回内容
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    @Override
    public PageResult getlistpage(int pageNum, int pageSize, String company_name, String product_name, String product_t_name) {
        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,company_name,product_name,product_t_name));
    }


    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    private PageInfo<Product_recall> getPageInfo(int pageNum,int pageSize, String company_name, String product_name, String product_t_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Product_recall> list=recallMapper.getListPage(company_name,product_name,product_t_name);
        if(list==null){
            throw new CompanyException("没有数据");
        }
        return new PageInfo<>(list);
    }

}
