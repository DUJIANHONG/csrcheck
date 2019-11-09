package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Important_notificationMapper;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.service.Important_notificationService;
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
 * @date: Created in 2019/11/9 14:48
 * @version:
 * @modified By:
 */
@Service
public class Important_notificationServiceImpl implements Important_notificationService {

    @Resource
    private Important_notificationMapper important_notificationMapper;
    @Override
    public PageResult getimportant_page(int pageNum, int pageSize, String product_name,String product_t_name) {

        return PageUtils.getPageResult(pageNum,pageSize,getPageInfo(pageNum,pageSize,product_name,product_t_name));
    }

    /**
     * 调用分页插件完成分页
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @param product_t_name
     * @return
     */
    private PageInfo<Important_notification> getPageInfo(int pageNum,int pageSize,String product_name,String product_t_name){
        PageHelper.startPage(pageNum,pageSize);
        List<Important_notification> list=important_notificationMapper.getimportant_page(product_name,product_t_name);
        if(list==null){
            throw new CompanyException("数据不为空");
        }
        return new PageInfo<>(list);
    }
}
