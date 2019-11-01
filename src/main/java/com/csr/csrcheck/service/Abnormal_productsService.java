package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 11:08
 * @version:
 * @modified By:
 */
public interface Abnormal_productsService {

    List<Abnormal_products> abnormallsitpage( );
}
