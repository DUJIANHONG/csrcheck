package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MilitrayServiceTest {
    @Resource
    private MilitaryService militaryService;
    @Test
    public void getFlight_checklist(){
        List<Product> result=militaryService.getMilitarylist();
        System.err.println(result);

    }
    @Test
    public void getFlight_checklist2() {
        List<Product> result2 = militaryService.getMilitarylist2();
        System.err.println(result2);
    }
}
