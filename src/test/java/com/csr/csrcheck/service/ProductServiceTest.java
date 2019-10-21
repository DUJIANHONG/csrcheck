package com.csr.csrcheck.service;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Resource
    private ProductService productService;
    public void getProductlist(){
       System.err.println(productService.getProductlist());
    }
    public void getProductlistbyname(){
        String product_name="产品名称";
     System.err.println(productService.getProductlistbyname(product_name));
    }
}
