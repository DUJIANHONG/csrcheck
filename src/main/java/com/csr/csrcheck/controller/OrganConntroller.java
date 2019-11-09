package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.OrganService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:31
 * @version:
 * @modified By:
 */
@RequestMapping("organ")
//@Controller
@RestController
@Slf4j
public class OrganConntroller extends BaseController{
    @Resource
    private OrganService organService;

    /**
     * 前十大投资机构（wxapi）
     * @param
     * @return
     * @throws IOException
     * @throws ServletException
     */
/*    @ResponseBody*/
    @GetMapping("organlist")
   public JsonResult<List<Company>> Companylist(){
        List<Company> list = organService.getOrganlist();
        if (list==null){
           throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
    //基本信息
    @GetMapping("organlist2")
    public JsonResult<List<Company>> Companylist2(){
        List<Company> list = organService.getOrganlist2();
        if (list==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
