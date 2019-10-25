package com.csr.csrcheck.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MilitaryMapperTest {
    @Resource
    private MilitaryMapper militaryMapper;
    @Test
    public void getProductlist(){
        System.err.println(militaryMapper.getMilitarylist());
    }
    @Test
    public void getProductlist2(){
        System.err.println(militaryMapper.getMilitarylist2());
    }

}
