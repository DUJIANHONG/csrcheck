package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 15:07
 */
public interface TheirService {

    //根据产品名称模糊查询
    public List<Product> getAlltheirByproduct_name(@Param("product_name") String product_name);

    //查询进口化妆品品牌
    public  List<Product> gettheirByimport(int t_id, int i_id);

    //查询化妆品生产厂家
    public List<Product> getComanyByProduct_t_id(int t_id);

    //查询所有重要通报
    public List<Important_notification> getAllNotification();
}
