package com.csr.csrcheck.service;

import com.csr.csrcheck.mapper.Abnormal_productsMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 11:20
 * @version:
 * @modified By:
 */
public class Abnormal_productsTest {

    @Resource
    private Abnormal_productsService abnormal_productsService;
    @Resource
    private Abnormal_productsMapper abnormal_productsMapper;

    @Test
    public void show(){
        List<Abnormal_products> list=null;
        try {
            list=abnormal_productsService.abnormallsitpage();
            for (Abnormal_products abnormal_products : list) {
                System.out.println(abnormal_products.getProduct().getCompany_name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
