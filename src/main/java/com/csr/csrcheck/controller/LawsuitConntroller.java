package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Lawsuit;
import com.csr.csrcheck.service.LawsuitService;
import com.csr.csrcheck.service.OrganService;
import com.csr.csrcheck.service.ex.LawsuitException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
