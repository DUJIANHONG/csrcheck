package com.csr.csrcheck.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateMapperTest {
    @Resource
    private EvaluateMapper evaluateMapper;
    @Test
    public void getProductlist(){
        System.err.println(evaluateMapper.getEvaluatelist());
    }

}
