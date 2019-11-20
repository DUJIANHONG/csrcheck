package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Business_risks;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Risk_classify;
import com.csr.csrcheck.pojo.Risk_type;
import com.csr.csrcheck.service.Business_risksService;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.LawsuitException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     *增加经营风险
     *  @param business_risks
     * @return
     */
    @RequestMapping(path = "addbussiness",method = RequestMethod.POST)
    public JsonResult<Void> addbussiness(Business_risks business_risks){
        business_risksService.addBusiness(business_risks);
        return new JsonResult<>(SUCCESS,OK);
    }

    /**
     *修改经营风险
     *  @param business_risks
     * @return
     */
    @RequestMapping(path = "updatebussiness",method = RequestMethod.POST)
    public JsonResult<Void> updatebussiness(Business_risks business_risks){
        business_risksService.updateBusiness(business_risks);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     *删除经营风险
     *  @param id
     * @return
     */
    @RequestMapping(path = "deletebussiness/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deletebussiness(@PathVariable(value = "id") int id){
        business_risksService.deleteBusiness(id);
        return new JsonResult<>(SUCCESS,OK);
    }
    @Resource
    private CompanyService companyService;

    /**
     * 下拉列表显示企业信息
     * @return
     */
    @RequestMapping(path = "getcompany",method = RequestMethod.POST)
    public JsonResult<List<Company>> getcompany(){
       List<Company>  list=companyService.getCommpanyByid();
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *下拉列表显示分险分类
     *  @return
     */
    @RequestMapping(path = "getriskclassify",method = RequestMethod.POST)
    public JsonResult<List<Risk_classify>> getriskclassify(){
        List<Risk_classify> list=business_risksService.findbylistclassify();
        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     *下拉列表显示分险类型
     *  @return
     */
    @RequestMapping(path = "getsriktype",method = RequestMethod.POST)
    public JsonResult< List<Risk_type>> getsriktype(){
        List<Risk_type> list=business_risksService.findbylisttype();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
