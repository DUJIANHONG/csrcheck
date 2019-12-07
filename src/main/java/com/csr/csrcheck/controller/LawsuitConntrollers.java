package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.util.JsonResults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/12/7 16:50
 * @version:
 * @modified By:
 */
@RequestMapping("lawsuits")
//@Controller
@RestController
@Slf4j
public class LawsuitConntrollers extends BaseController{

    @Resource
    private LawsuitService lawsuitService;


       int count=lawsuitService.count();

    /**
     * 根据企业名称、案件类型、文书类型、被告、发布时间 分页查询法律诉讼
     * @param company_name
     * @param casetype
     * @param doctype
     * @param defendants
     * @param submittime
     * @return
     */
    @RequestMapping("lawsuits")
    public JsonResults<List<Lawsuit>> lawsuits(String company_name,
                                               String casetype,
                                               String doctype,
                                               String defendants,
                                               String submittime){
        List<Lawsuit> list=lawsuitService.getlistpages(company_name,casetype,doctype,defendants,submittime);
        log.info("lawsuit-------------------------------------->company_name:"+company_name);
        log.info("lawsuit-------------------------------------->casetype:"+casetype);
        log.info("lawsuit-------------------------------------->doctype:"+doctype);
        log.info("lawsuit-------------------------------------->defendants:"+defendants);
        log.info("lawsuit-------------------------------------->submittime:"+submittime);
        return new JsonResults<>(code,count,OK,list);
    }
}
