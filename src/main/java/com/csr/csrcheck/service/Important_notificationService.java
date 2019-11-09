package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 14:45
 * @version:
 * @modified By:
 */
public interface Important_notificationService {

    /**
     * 根据产品名称分页查询化妆品重要通报
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    PageResult getimportant_page(int pageNum,int pageSize, String product_name,String product_t_name);
}
