package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageRequest;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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
     * @param
     * @return
     * @throws IOException
     * @throws ServletException
     */
/*    @ResponseBody*/
    @GetMapping("companylist")
   public JsonResult<List<Company>> Companylist(){
        List<Company> list = companyService.getCommpanylist();
        if (list==null){
           throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     * 根据公司名模糊查询公司信息
     * @param name
     * @return
     */
    @GetMapping("companylist2")
    public JsonResult<List<Company>> CompanyList2(@RequestParam(value = "name") String name){
        List<Company> list2=companyService.getCommpanylistbyname(name);
        if (list2==null) {
            throw new CompanyException("没有数据哦");
        }
        return new JsonResult<>(SUCCESS,OK,list2);
   }

      @GetMapping("companypage")
       public JsonResult<Object> findCompanyPage( PageRequest pageRequest){
          PageResult page=companyService.findPage(pageRequest);
          if(page==null){
              throw new CompanyException("没有数据");
          }
        return new JsonResult<>(SUCCESS,OK,page);
   }
}
