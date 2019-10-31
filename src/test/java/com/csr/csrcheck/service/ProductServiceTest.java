package com.csr.csrcheck.service;


import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.util.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
@Test
    public void name(){
      PageResult list=productService.listpage(1,5,"");
        System.out.println(list);
    }
}
