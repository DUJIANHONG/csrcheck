package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.pojo.Product_type;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.Product_typeService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.Flight_checkException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestMapping("flight_check")
//@Controller
@RestController
@Slf4j
public class Flight_checkController extends BaseController{
    @Resource
    private IFlight_checkService iFlight_checkService;

    @Resource
    private Product_typeService productTypeService;
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
            throw new Flight_checkException("没有企业中的飞行数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
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
            throw new Flight_checkException("没有化妆品中的飞行数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
    /**
     * 查医疗器械中的飞行检查
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping("flight_checkllist3")
    public JsonResult<List<Flight_check>> Flight_checklist3( HttpServletResponse response) throws IOException, ServletException {
        List<Flight_check> list = iFlight_checkService.getFlight_checklist3();
        if (list==null){
            throw new Flight_checkException("没有医疗器械中的飞行数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     * 根据企业名称,产品名称、产品类型名称、检查编号、公布日期查询
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @param check_no
     * @param publication
     * @return
     */
    @RequestMapping("flightcheck")
    public JsonResult<Object> flightcheck(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "5") int pageSize,
                                          String company_name,
                                          String product_name,
                                          String product_t_name,
                                          String check_no,
                                          String publication){
        PageResult pageResult=iFlight_checkService.getListpage(pageNum,pageSize,company_name,product_name,product_t_name,check_no,publication);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        log.info("flightcheck--------------------------->pageNum:"+pageNum);
        log.info("flightcheck--------------------------->pageSize:"+pageSize);
        log.info("flightcheck--------------------------->company_name:"+company_name);
        log.info("flightcheck--------------------------->product_name:"+product_name);
        log.info("flightcheck--------------------------->product_t_name:"+product_t_name);
        log.info("flightcheck--------------------------->check_no:"+check_no);
        log.info("flightcheck--------------------------->publication:"+publication);
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

    /**
     *产品类型
     *  @return
     */
    @GetMapping("productType")
    public JsonResult<List<Product_type>> productType(){
        List<Product_type> list=productTypeService.getlist();
        if(list==null){
            throw new CompanyException("数据为空");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
