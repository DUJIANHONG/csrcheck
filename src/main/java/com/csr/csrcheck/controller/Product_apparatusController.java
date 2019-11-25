package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.ProductException;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.Product_apparatusService;
import com.csr.csrcheck.util.JsonResult;
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
 * @date: Created in 2019/10/31 13:58
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("product")
@Slf4j
public class Product_apparatusController extends BaseController {

    @Resource
    private Product_apparatusService product_apparatusService;

    /**
     * 根据产品名模糊查询医疗器械信息（wxapi）
     * @param name
     * @return
     */
    @GetMapping("produc_apparatustlist")
    public JsonResult<List<Product>> Productlistbyname(@RequestParam(value = "name") String name){
        List<Product> list=product_apparatusService.getProductlistbyname(name);

        if (list==null) {
            throw new ProductException("没有数据哦");
        }
      /*  if (name.equals("") || name==null) {

              throw new com.csr.csrcheck.service.ex.ProductException("请输入产品名称");
            }*/

        return new JsonResult<>(code,OK,list);
    }
}
