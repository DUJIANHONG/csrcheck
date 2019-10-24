package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageSupport;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
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
     * @param name
     * @return
     */
    @GetMapping("companylist2")
    public JsonResult<List<Company>> CompanyList2(@RequestParam(value = "name") String name){
        List<Company> list2=companyService.getCommpanylistbyname(name);
        Company company=new Company();
        if (list2==null) {
            throw new CompanyException("没有数据哦");
        }
        return new JsonResult<>(SUCCESS,list2);
   }

    /**
     * 分页查询公司信息&根据公司名称模糊查询
     * @param name
     * @param pageIndex
     * @return
     */
   @GetMapping("companylist3")
   public Object companylist(String name,String pageIndex){
       List<Company> list3=null;
       String cname=name;
       //页面容量
       int pageSize=5;
       //当前页码
       Integer currentPageNo=1;
       if(cname==null){
            cname="";
       }
       if(pageIndex!=null){
           try {
               currentPageNo = Integer.valueOf(pageIndex);
           } catch (NumberFormatException e) {
               e.printStackTrace();
           }
       }
       //总数量
       Integer totalCount = 0;
       try {
           totalCount=companyService.count(cname);
       } catch (Exception e) {
           e.printStackTrace();
       }
       //总页数
       PageSupport page=new PageSupport();
       page.setCurrentPageNo(currentPageNo);
       page.setPageSize(pageSize);
       page.setTotalCount(totalCount);
       int totalPageCount = page.getTotalPageCount();
       //控制首页和尾页
       if(currentPageNo <1){
           currentPageNo=1;
       }else if(currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
       }
       try {
           list3 = companyService.getCommpanylistbynames(name,currentPageNo,pageSize);
       } catch (Exception e) {
           e.printStackTrace();
       }
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("list3",list3);
       map.put("name",cname);
       map.put("currentPageNo",page.getCurrentPageNo());
       map.put("pageSize",page.getPageSize());
       map.put("totalPageCount",page.getTotalPageCount());
       map.put("totalCount",page.getTotalCount());
       return map;
   }
}
