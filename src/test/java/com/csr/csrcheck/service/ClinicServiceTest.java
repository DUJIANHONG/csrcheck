package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Flight_check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClinicServiceTest {
    @Resource
    private ClinicService clinicService;
    @Test
    public void getFlight_checklist(){
        List<Clinic> result=clinicService.getCliniclist();
        System.err.println(result);
    }
}
