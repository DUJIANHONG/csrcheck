package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
    @Resource
    private ProductMapper productMapper;
    @Test
    public void getProductlist(){
        System.err.println(productMapper.getProductlist());
    }
    @Test
    public void getProductlistbyname(){
        String product_name="产品名称";
        System.err.println(productMapper.getProductlistbyname(product_name));
    }
    @Test
    public void getProductpage(){
        String name="甲";
        List<Product> list=productMapper.listpage(name);
        for (Product product : list) {
            System.err.println(product.getCompany_name());;
        }
    }
}
