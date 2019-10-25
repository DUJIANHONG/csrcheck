package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.service.impl.RecallServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:50
 */
@RestController
@RequestMapping("recall")
public class RecallConntroller extends BaseController{
    @Resource
    private RecallServiceImpl recallService;
    @GetMapping("recalllist")
    public JsonResult<List<Product_recall>> getlist(){
        List<Product_recall> list = recallService.getlist();
        return new JsonResult<>(SUCCESS,list);
    }
}
