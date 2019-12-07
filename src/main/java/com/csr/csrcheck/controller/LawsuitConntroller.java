package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.LawsuitService;
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
@RequestMapping("lawsuit")
//@Controller
@RestController
@Slf4j
public class LawsuitConntroller extends BaseController{

    private static final int count=1000;
    @Resource
    private LawsuitService lawsuitService;

    /**
     * 查询法律诉讼（wxapi）
     * @param
     * @return
     * @throws IOException
     * @throws ServletException
     */
/*    @ResponseBody*/
    @GetMapping("lawsuitlist")
   public JsonResult<List<Lawsuit>> Companylist(){
        List<Lawsuit> list = lawsuitService.getLawsuitlist();
        if (list==null){
           throw new LawsuitException("没有数据");
        }
        return new JsonResult<>(code,OK,list);
    }


    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
@RequestMapping("lawsuit")
    public JsonResult<Object> lawsuit(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, String company_name,
                                      String casetype,
                                      String doctype,
                                      String defendants,
                                      String submittime){
        PageResult pageResult=lawsuitService.getlistpage(pageNum,pageSize,company_name,casetype,doctype,defendants,submittime);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        log.info("lawsuit-------------------------------------->pageNum:"+pageNum);
        log.info("lawsuit-------------------------------------->pageSize:"+pageSize);
        log.info("lawsuit-------------------------------------->company_name:"+company_name);
        log.info("lawsuit-------------------------------------->casetype:"+casetype);
        log.info("lawsuit-------------------------------------->doctype:"+doctype);
        log.info("lawsuit-------------------------------------->defendants:"+defendants);
        log.info("lawsuit-------------------------------------->submittime:"+submittime);
        return new JsonResult<>(code,OK,pageResult);
    }

    /**
     * 增加
     * @param lawsuit
     * @return
     */
    @RequestMapping(path = "addlawsuit",method = RequestMethod.POST)
    public JsonResult<Void> addlawsuit(Lawsuit lawsuit){
         lawsuitService.addlawsuit(lawsuit);
         return new JsonResult<>(code,OK);
    }
    /**
     * 修改
     * @param lawsuit
     * @return
     */
    @RequestMapping(path = "updatelawsuit",method = RequestMethod.POST)
    public JsonResult<Void> updatelawsuit(Lawsuit lawsuit){
         lawsuitService.updatelawsuit(lawsuit);
         return new JsonResult<>(code,OK);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(path = "deletelawsuit/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deletelawsuit(@PathVariable(value = "id") int id){
         lawsuitService.deletelawsuit(id);
         return new JsonResult<>(code,OK);
    }
    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping(path = "findlawsuit/{id}",method = RequestMethod.POST)
    public JsonResult<Lawsuit> findlawsuit(@PathVariable(value = "id") int id){
        Lawsuit lawsuit = lawsuitService.findlawsuit(id);
         return new JsonResult<>(code,OK,lawsuit);
    }

    @Resource
    private CompanyService companyService;
    /**
     *下拉框展示企业数据
     *  @return
     */
    @RequestMapping(path = "showcompany",method = RequestMethod.POST)
    public JsonResult<List<Company>> showcompany() {
        List<Company> list = companyService.getCommpanylist();
        return new JsonResult<>(code, OK, list);
    }

}
