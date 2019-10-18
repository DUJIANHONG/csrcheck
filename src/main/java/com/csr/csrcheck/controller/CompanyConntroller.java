package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/15 11:31
 * @version:
 * @modified By:
 */
@RequestMapping("company")
//@Controller
@RestController
@Slf4j
public class CompanyConntroller extends BaseController{
    @Resource
    private CompanyService companyService;

    /**
     * 查询公司信息
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
/*    @ResponseBody*/
    @GetMapping("companylist")
   public JsonResult<List<Company>> Companylist(HttpServletResponse response) throws IOException, ServletException {
        List<Company> list = companyService.getCommpanylist();
        if (list==null){
           throw new CompanyException("没有数据");
        }

        return new JsonResult<>(SUCCESS,list);
    }

    /**
     * 根据公司名查询公司信息
     * @param company_name
     * @return
     */
    @GetMapping("companylist2")
    public JsonResult<List<Company>> CompanyList2(@RequestParam(value = "name") String company_name){
        List<Company> list2=companyService.getCommpanylistbyname(company_name);
        if (list2==null) {
            throw new CompanyException("没有数据哦");
        }else if(company_name==null&company_name.equals("")){
            throw new CompanyException("没有这个产品名称");
        }
        return new JsonResult<>(SUCCESS,list2);
   }
}
