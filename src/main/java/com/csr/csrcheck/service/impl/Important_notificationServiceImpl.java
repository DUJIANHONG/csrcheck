package com.csr.csrcheck.service.impl;

import com.csr.csrcheck.mapper.Important_notificationMapper;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.Important_notificationService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public List<Product> selectproduct() {
        return important_notificationMapper.selectproduct();
    }

    @Override
    public Important_notification selectByimportant_id(int id) {
        return important_notificationMapper.selectByimportant_id(id);
    }

    @Override
    public int addimportant(Important_notification important_notification) {
        int result = important_notificationMapper.addimportant(important_notification);
        if (result != 1){
            throw new CompanyException("未完成添加");
        }
        return result;
    }
    @Override
    public int updateimportant(Important_notification important_notification) {
        int result = important_notificationMapper.updateimportant(important_notification);
        if (result != 1){
            throw new CompanyException("未完成修改");
        }
        return result;
    }

    @Override
    public int deleteimportantByid(int id) {
        return important_notificationMapper.deleteimportantByid(id);
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
