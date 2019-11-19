package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company_news;
import com.csr.csrcheck.service.impl.Company_newsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-11-14 10:45
 */
@Controller
@RequestMapping("com_news")
public class Company_newsController extends BaseController {
    @Resource
    private Company_newsServiceImpl company_newsService;
    @ResponseBody
    @RequestMapping("news")
    public JsonResult<List<Company_news>> select_All(){
        List<Company_news> list = company_newsService.selectAllBycompany_id(4);
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
