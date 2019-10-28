package com.csr.csrcheck.csrhtcontroller;

import com.csr.csrcheck.controller.BaseController;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/27 14:52
 * @version:
 * @modified By:
 */
@RequestMapping("csrht")
@Controller
public class HTConntroller extends BaseController {

    @Resource
    private CompanyService companyService;
    /**
     * 公司信息页面
     * @return
     */
    @RequestMapping("company")
    public String Company(){
        return "company";
    }

    /**
     * 分页查询
     * @param
     * @return
     */
    @RequestMapping("companypage")
    public String findCompanyPage(@RequestParam(defaultValue = "1") int pageNum,
                                  @RequestParam(defaultValue = "5") int pageSize,
                                  String company_name, Model model){
        PageResult page=companyService.findPage(pageNum,pageSize,company_name);
        if(page==null){
            throw new CompanyException("没有数据");
        }
        model.addAttribute("page",page);
        return "csrht/company";
    }

}
