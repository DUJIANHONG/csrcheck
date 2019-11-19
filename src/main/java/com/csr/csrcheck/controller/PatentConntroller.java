package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.impl.PatentSerciceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 14:05
 */
@RestController
@RequestMapping("patent")
public class PatentConntroller extends BaseController {
    @Resource
    private PatentSerciceImpl patentSercice;
    @GetMapping("patentlist")
    public JsonResult<List<Product>> getlistByCompany_id(){
        List<Product> list = patentSercice.getListByProduct(4);
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
