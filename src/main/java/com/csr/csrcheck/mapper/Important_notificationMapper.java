package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Important_notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 14:31
 * @version:
 * @modified By:
 */
public interface Important_notificationMapper {

    /**
     * 根据产品名称分页查询重要通报
     * @param product_name
     * @return
     */
    List<Important_notification> getimportant_page(@Param(value = "product_name") String product_name,
                                                   @Param(value = "product_t_name")String product_t_name);
}
