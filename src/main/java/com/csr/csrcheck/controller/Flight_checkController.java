package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.pojo.Product_type;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ProductService;
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

        return new JsonResult<>(code,OK,list);
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

        return new JsonResult<>(code,OK,list);
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

        return new JsonResult<>(code,OK,list);
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
        return new JsonResult<>(code,OK,pageResult);
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
        return new JsonResult<>(code,OK,list);
    }

    /**
     * 增加
     * @param flight_check
     * @return
     */
    @RequestMapping(path = "addflight",method = RequestMethod.POST)
    public JsonResult<Void> addflight(Flight_check flight_check){
        iFlight_checkService.addFlightcheck(flight_check);
        return new JsonResult<>(code,OK);
    }

    /**
     * 修改
     * @param flight_check
     * @return
     */
    @RequestMapping(path = "updateflight",method = RequestMethod.POST)
    public JsonResult<Void> updateflight(Flight_check flight_check){
        iFlight_checkService.updateFlightcheck(flight_check);
        return new JsonResult<>(code,OK);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(path = "deleteflight/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deleteflight(@PathVariable(value = "id") int id){
        iFlight_checkService.deleteFlightcheck(id);
        return new JsonResult<>(code,OK);
    }

    /**
     * 跟据id查找
     * @param id
     * @return
     */
    @RequestMapping(path = "findflight/{id}",method = RequestMethod.POST)
    public JsonResult<Flight_check> findflight(@PathVariable(value = "id") int id){
        Flight_check flight_check=iFlight_checkService.findflightByid(id);
        return new JsonResult<>(code,OK,flight_check);
    }
    /**
     * 下拉框展示产品数据
     * @return
     */
    @Resource
    private ProductService productService;
    @RequestMapping(path="listproduct", method= RequestMethod.POST)
    public JsonResult<List<Product>> listproduct(){
        List list=productService.list();
        return new JsonResult<>(code,OK,list);
    }
}
