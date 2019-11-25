package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Five_supplier;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.Five_SupplierService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/8 15:34
 * @version:
 * @modified By:
 */
@RestController
@Slf4j
@RequestMapping("Five")
public class Five_SupplierController extends BaseController {

    @Resource
    private Five_SupplierService fiveSupplierService;

    /**
     *分页查询前五大供应商
     *  @param pageNum
     * @param pageSize
     * @param supplier_name
     * @return
     */
    @GetMapping("fiveSuppler")
    public JsonResult<PageResult> fiveSuppler(@RequestParam(defaultValue = "1") int pageNum,
                                                       @RequestParam(defaultValue = "5") int pageSize,
                                                       String supplier_name){
        PageResult pageResult=null;
        try {
            pageResult=fiveSupplierService.getListFive(pageNum,pageSize,supplier_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("fiveSuppler------------------>pageResult"+pageResult);
        log.info("fiveSuppler------------------>pageNum"+pageNum);
        log.info("fiveSuppler------------------>pageSize"+pageSize);
        log.info("fiveSuppler------------------>supplier_name"+supplier_name);
        return new JsonResult<>(code,OK,pageResult);
    }

    /**
     *增加前五大供应商
     *  @param five_Supplier
     * @return
     */
    @RequestMapping(path = "addFive",method = RequestMethod.POST)
    public JsonResult<Void> addFive(Five_supplier five_Supplier){
        fiveSupplierService.addFivesupplier(five_Supplier);
        return new JsonResult<>(code,OK);
    }
    /**
     *修改前五大供应商
     *  @param five_Supplier
     * @return
     */
    @RequestMapping(path = "updateFive",method = RequestMethod.POST)
    public JsonResult<Void> updateFive(Five_supplier five_Supplier){
        fiveSupplierService.updateFiveSupplier(five_Supplier);
        return new JsonResult<>(code,OK);
    }
    /**
     *删除前五大供应商
     *  @param id
     * @return
     */
    @RequestMapping(path = "deleteFive/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deleteFive(@PathVariable(value = "id") int id){
        fiveSupplierService.deleteFiveSupplier(id);
        return new JsonResult<>(code,OK);
    }

    /**
     * 根据id查找前五大供应商
     * @param id
     * @return
     */
    @RequestMapping(path = "findFive/{id}",method = RequestMethod.POST)
    public JsonResult<Five_supplier> findFive(@PathVariable(value = "id") int id){
        Five_supplier five_Supplier=fiveSupplierService.fingfiveByid(id);
        if(five_Supplier==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(code,OK,five_Supplier);
    }
    @Resource
    private CompanyService companyService;

    /**
     *下拉框展示企业数据
     *  @return
     */
    @RequestMapping(path = "showcompany",method = RequestMethod.POST)
    public JsonResult<List<Company>> showcompany(){
        List<Company> list = companyService.getCommpanylist();
        return new JsonResult<>(code,OK,list);
    }
}
