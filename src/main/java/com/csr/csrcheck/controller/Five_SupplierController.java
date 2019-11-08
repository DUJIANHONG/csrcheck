package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Five_Supplier;
import com.csr.csrcheck.service.Five_SupplierService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }
}
