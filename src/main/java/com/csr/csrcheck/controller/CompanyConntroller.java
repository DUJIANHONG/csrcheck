package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Special_bulletin;
import com.csr.csrcheck.service.CompanyService;
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
@RequestMapping("company")
//@Controller
@RestController
@Slf4j
public class CompanyConntroller extends BaseController{
    @Resource
    private CompanyService companyService;

    /**
     * 查询公司信息（wxapi）
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
     * 根据公司名模糊查询公司信息（wxapi）
     * @param name
     * @return
     */
    @GetMapping("companylist2")
    public JsonResult<List<Company>> CompanyList2( String name){
        List<Company> list2=companyService.getCommpanylistbyname(name);
        if (list2==null) {
            throw new CompanyException("没有数据哦");
        }
        if (name.equals("") || name==null){
            throw new com.csr.csrcheck.service.ex.CompanyException("请输入公司名称");
        }
        return new JsonResult<>(SUCCESS,OK,list2);
   }

    /**
     * 分页查询
     * @param
     * @return
     */
      @RequestMapping("companypage")
       public Object findCompanyPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,String company_name){
          PageResult page=companyService.findPage(pageNum,pageSize,company_name);
          if(page==null){
              throw new CompanyException("没有数据");
          }
        return page;
   }

    /**
     * 查询所有公司的特别公告
     * @return
     */
    @GetMapping("special")
        public JsonResult<List<Special_bulletin>> getAll(){
          List<Special_bulletin> list = companyService.getAll();
          return new JsonResult<>(SUCCESS,OK,list);
        }
}
