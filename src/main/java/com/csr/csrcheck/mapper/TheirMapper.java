package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 13:49
 */
public interface TheirMapper {

    //查询产品表中的所有化妆品
    public List<Product> getAlltheirByproduct_name(@Param("product_name") String product_name);

    //查询进口/国产化妆品品牌
    public  List<Product> gettheirByimport(int t_id,int i_id);

    //查询化妆品生产厂家
    public List<Product> getComanyByProduct_t_id(int t_id);

    //查询所有重要通报
    public List<Important_notification> getAllNotification();
}
