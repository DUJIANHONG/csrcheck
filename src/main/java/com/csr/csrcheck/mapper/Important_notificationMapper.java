package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
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

    /**
     *下拉框查询产品名称
     */
    List<Product> selectproduct();
    /**
     增加产品重要通知信息
     */
    int addimportant(Important_notification important_notification);

    /**
     * 修改前根据产品id查询产品重要通知信息
     */
    Important_notification selectByimportant_id(int id);

    /**
     * 修改产品重要通知信息
     */
    int updateimportant(Important_notification important_notification);

    /**
     * 根据产品重要通知id删除
     */
    int deleteimportantByid(int id);
}
