package com.csr.csrcheck.controller;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Product_type;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/31 13:58
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("product")
@Slf4j
public class ProductController extends BaseController {

    @Resource
    private ProductService productService;
    @RequestMapping("productpage")
    public JsonResult<Object> productpage(@RequestParam(defaultValue = "1") int pageNum,
                                                 @RequestParam(defaultValue = "5") int pageSize,
                                                 String product_name){
        PageResult pageResult=productService.listpage(pageNum,pageSize,product_name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

    public String selectproduct_type(Model model){
        List<Product_type> list = productService.selectProduct_type();
        return "/";
    }
}
