package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Five_supplier;
import com.csr.csrcheck.pojo.Stock_alteration;
import com.csr.csrcheck.service.impl.EcosphereSreviceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-31 17:32
 */
@RestController
@RequestMapping("ecosphere")
public class EcosphereController extends BaseController{
    @Resource
    private EcosphereSreviceImpl ecosphereSrevice;
    @RequestMapping("five_suplier")
    public JsonResult<List<Five_supplier>> getAllSuplier(){
        List<Five_supplier> list = ecosphereSrevice.getAllSupplier(4);
        return new JsonResult<>(SUCCESS,OK,list);
    }
    @RequestMapping("alteration")
    public JsonResult<List<Stock_alteration>> getAllalteration(){
        List<Stock_alteration> list = ecosphereSrevice.getAllAlteration(4);
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
