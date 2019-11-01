package com.csr.csrcheck.service;

import com.csr.csrcheck.mapper.Abnormal_productsMapper;
import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.util.PageRequest;
import com.csr.csrcheck.util.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/1 11:20
 * @version:
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Abnormal_productsTest {

    @Resource
    private Abnormal_productsService abnormal_productsService;
    @Resource
    private Abnormal_productsMapper abnormal_productsMapper;

    @Test
    public void show(){
      PageResult pageResult =null;
        try {
            pageResult =abnormal_productsService.abnormallsitpage(1,5,"");
            System.out.println(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
