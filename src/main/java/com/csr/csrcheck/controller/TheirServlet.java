package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.ProductException;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.impl.TheirServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.stereotype.Controller;
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
public class TheirServlet extends BaseController{

    @Resource
    private TheirServiceImpl theirService;

    @RequestMapping("theirlist")
    @ResponseBody
    public JsonResult<List<Product>> TheirList(String name){
        List<Product> list = theirService.getAlltheirByproduct_name(name);
        if (name == null || name.equals("")){
            throw new ProductException("请输入产品名称");
        }
        if (list == null){
            throw new ProductException("没有关联数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
    @ResponseBody
    @RequestMapping("import")
    public JsonResult<List<Product>> gettheirByimport(){
        List<Product> list = theirService.gettheirByimport(2,1);
        if (list==null){
            throw new ProductException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }

    @ResponseBody
    @RequestMapping("domestic")
    public JsonResult<List<Product>> gettheirBydomestic(){
        List<Product> list = theirService.gettheirByimport(2,2);
        if (list==null){
            throw new ProductException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,list);
    }
    @ResponseBody
    @RequestMapping("/company")
    public JsonResult<List<Product>> getComanyByProduct_t_id(){
        List<Product> list = theirService.getComanyByProduct_t_id(2);
        return new JsonResult<>(SUCCESS,OK,list);
    }
    @ResponseBody
    @RequestMapping("/Notification")
    public JsonResult<List<Important_notification>> getAllNotification(){
        List<Important_notification> list = theirService.getAllNotification();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
