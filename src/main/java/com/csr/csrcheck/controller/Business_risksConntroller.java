package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.Business_risksService;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.LawsuitException;
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
@RequestMapping("business_risks")
//@Controller
@RestController
@Slf4j
public class Business_risksConntroller extends BaseController{
    @Resource
    private Business_risksService business_risksService;

    /**
     * 查询法律诉讼（wxapi）
     * @param
     * @return
     * @throws IOException
     * @throws ServletException
     */
/*    @ResponseBody*/
    @GetMapping("business_riskslist")
   public JsonResult<List<Business_risks>> Companylist(){
        List<Business_risks> list = business_risksService.getBusiness_riskslist();
        if (list==null){
           throw new LawsuitException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }


    /**
     * 分页查询经营风险
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @RequestMapping("bussiness")
    public JsonResult<Object> bussiness(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "5") int pageSize,
                                        @RequestParam(value = "name",required = false) String company_name){
        PageResult pageResult=business_risksService.getListpage(pageNum,pageSize,company_name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

}
