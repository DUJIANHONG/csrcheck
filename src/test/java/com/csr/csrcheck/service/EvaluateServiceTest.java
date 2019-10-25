package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Evaluate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateServiceTest {
    @Resource
    private EvaluateService evaluateService;
    @Test
    public void getEvaluatelist(){
        List<Evaluate> result=evaluateService.getEvaluatelist();
        System.err.println(result);
    }
}
