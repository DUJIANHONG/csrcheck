package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.TheirService;
import com.csr.csrcheck.util.JsonResult;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-17 15:15
 */

@Controller

@RequestMapping("their")
public class TheirServlet {

    public static final int SUCCESS = 2000;
    @Resource
    private TheirService theirService;

    @ResponseBody
    @GetMapping("theirlist")
    public JsonResult<List<Product>> TheirList(){
        List<Product> list = theirService.getAlltheirByproduct_id(2,"");
        return new JsonResult<>(SUCCESS,list);
    }
}
