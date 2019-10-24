package com.csr.csrcheck.controller;



import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.service.ex.ProductException;
import com.csr.csrcheck.service.ex.ProductNotFoundException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("product")
//@Controller
@RestController
@Slf4j
public class EquipmentController extends BaseController{
    @Resource
    private ProductService productService;
    @GetMapping("productlist")
    /**
     * 查询产品信息
     */
    public JsonResult<List<Product>> Companylist(HttpServletResponse response) throws IOException, ServletException {
        List<Product> list = productService.getProductlist();
        if (list==null){
            throw new ProductException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
    @GetMapping("productlist2")
    /**
     * 根据产品名称模糊查询产品信息
     */
    public JsonResult<List<Product>> CompanyList2(@RequestParam(value = "name") String product_name){
        List<Product> list2=productService.getProductlistbyname(product_name);
        if (list2==null) {
            throw new ProductException("没有数据哦");
        }
        return new JsonResult<>(SUCCESS,OK,list2);
    }
}
