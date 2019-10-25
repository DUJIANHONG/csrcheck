package com.csr.csrcheck.mapper;

import com.csr.csrcheck.pojo.Flight_check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Flight_checkMapperTest {
    @Resource
    private Flight_checkMapper flight_checkMapper;
    @Test
    public void getFlight_checklist(){
       List<Flight_check> result=flight_checkMapper.getFlight_checklist();
       System.err.println(result);
    }
    @Test
    public void getFlight_checklist2(){

        List<Flight_check> result=flight_checkMapper.getFlight_checklist2();
        System.err.println(result);
    }
}
