package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.MilitaryService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("military")
//@Controller
@RestController
@Slf4j
/**
 * 查国产器械的临床
 */
public class MilitaryController extends BaseController{
    @Resource
    private MilitaryService militaryService;
    @GetMapping("militarylist")
    public JsonResult<List<Product>> Militarylist(HttpServletResponse response) throws IOException, ServletException {
        List<Product> list = militaryService.getMilitarylist();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     * 查进口器械的临床
     */

    @GetMapping("militarylist2")
    public JsonResult<List<Product>> Militarylist2(HttpServletResponse response) throws IOException, ServletException {
        List<Product> list = militaryService.getMilitarylist2();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
}
