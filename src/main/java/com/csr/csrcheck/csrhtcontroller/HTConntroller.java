package com.csr.csrcheck.csrhtcontroller;

import ch.qos.logback.classic.Logger;
import com.csr.csrcheck.controller.BaseController;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.util.Constants;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import com.csr.csrcheck.util.PageSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/27 14:52
 * @version:
 * @modified By:
 */
@RequestMapping("csrht")
@Controller
@Slf4j
public class HTConntroller extends BaseController {

    @Resource
    private CompanyService companyService;

    /**
     * 公司信息页面
     *
     * @return
     */
    @RequestMapping("companyjsp")
    public String findCompanyPage(@RequestParam(value = "company_name", required = false) String company_name,
                                  @RequestParam(value = "pageIndex", required = false) String pageIndex,
                                  Model model) {


        log.info("findCompanyPage----------------------->company_name:" + company_name);
        log.info("findCompanyPage----------------------->pageIndex:" + pageIndex);

        List<Company> list = null;
        //页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;
        if(pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //总数量
        int totalCount=0;
        try {
            totalCount = companyService.getCompanyCount(company_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        try {
            list = companyService.getCommpanylistpage(company_name, currentPageNo, pageSize);
            System.out.println(list.size());
        } catch (Exception e) {
            throw new CompanyException(e);
        }
        model.addAttribute("list", list);
        model.addAttribute("page", pages);
        model.addAttribute("company_name", company_name);
            return "company";
        }
    }

