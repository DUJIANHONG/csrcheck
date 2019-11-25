package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.service.impl.Abnormal_productsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-25 17:20
 */
@RestController
@RequestMapping("abnormal")
public class Abnormal_productsController extends BaseController{
    @Resource
    private Abnormal_productsServiceImpl abnormal_productsService;
        @RequestMapping("product")
        public JsonResult<List<Abnormal_products>> getAll(){
            List<Abnormal_products> list = abnormal_productsService.getAllProduct();
            return new JsonResult<>(code,OK,list);
        }
}
