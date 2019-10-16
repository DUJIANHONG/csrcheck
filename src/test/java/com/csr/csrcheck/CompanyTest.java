package com.csr.csrcheck;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 13:25
 * @version:
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyTest {

    @Resource
    private CompanyService companyService;

/*    @Test
    public  void List(){
        List<Company> list=null;
        try {
            list=companyService.getCommpanylist();
            for (Company company : list) {
                System.out.println(company.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
