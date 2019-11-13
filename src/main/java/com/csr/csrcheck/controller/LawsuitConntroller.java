package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.OrganService;
import com.csr.csrcheck.service.ex.LawsuitException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("lawsuit")
//@Controller
@RestController
@Slf4j
public class LawsuitConntroller extends BaseController{
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
        return new JsonResult<>(SUCCESS,OK,list);
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
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

}
