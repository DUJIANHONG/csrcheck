package com.csr.csrcheck.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContendMapperTest {
    @Resource
    private ContendMapper contendMapper;
    @Test
    public void getContendList(){
        System.err.println(contendMapper.getContendList());
    }

}
