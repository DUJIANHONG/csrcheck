package com.csr.csrcheck.service;

import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Clinic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApprovalsServiceTest {
    @Resource
    private ApprovalsService approvalsService;
    @Test
    public void getFlight_checklist(){
        List<Approvals> result=approvalsService.getApprovalslist();
        System.err.println(result);
    }
}
