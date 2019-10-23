package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ex.Flight_checkException;
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

@RequestMapping("flight_check")
//@Controller
@RestController
@Slf4j
public class Flight_checkController extends BaseController{
    @Resource
    private IFlight_checkService iFlight_checkService;

    /**
     * 查企业中的飞行检查
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping("flight_checkllist")
    public JsonResult<List<Flight_check>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Flight_check> list = iFlight_checkService.getFlight_checklist();
        if (list==null){
            throw new Flight_checkException("没有飞行数据");
        }

        return new JsonResult<>(SUCCESS,list);
    }

    /**
     * 查化妆品中的飞行检查
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping("flight_checkllist2")
    public JsonResult<List<Flight_check>> Flight_checklist2( HttpServletResponse response) throws IOException, ServletException {
        List<Flight_check> list = iFlight_checkService.getFlight_checklist2();
        if (list==null){
            throw new Flight_checkException("没有飞行数据");
        }

        return new JsonResult<>(SUCCESS,list);
    }
}
