package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.service.impl.RecallServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:50
 */
@Slf4j
@Controller
@RequestMapping("recall")
public class RecallConntroller extends BaseController{
    @Resource
    private RecallServiceImpl recallService;
    @GetMapping("recalllist")
    @ResponseBody
    public JsonResult<List<Product_recall>> getlist(){
        List<Product_recall> list = recallService.getlist();
        return new JsonResult<>(code,OK,list);
    }

    /**
     * 根据产品名称，产品类型名称，企业名称分页查询产品召回内容
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @param product_t_name
     * @return
     */
    @ResponseBody
    @RequestMapping("recall")
    public JsonResult<Object> productrecall(@RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            String company_name, String product_name,
                                            String product_t_name){
        PageResult pageResult=recallService.getlistpage(pageNum,pageSize,company_name,product_name,product_t_name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        log.info("productrecall----------------------------------------->pageNum:"+pageNum);
        log.info("productrecall----------------------------------------->pageSize:"+pageSize);
        log.info("productrecall----------------------------------------->company_name:"+company_name);
        log.info("productrecall----------------------------------------->product_name:"+product_name);
        log.info("productrecall----------------------------------------->product_t_name:"+product_t_name);
        return new JsonResult<>(code,OK,pageResult);
    }

    /**
     * 跳转到添加页面
     * @param model
     * @return
     */
    @RequestMapping("addrecall")
    public String selectproduct(Model model){
        List<Product> list = recallService.selectproduct();
        model.addAttribute("product",list);
        return "addrecall";
    }

    /**
     * 保存新增产品召回信息
     * @param product_recall
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveaddrecall", method= RequestMethod.POST)
    public JsonResult<Void> addrecall(Product_recall product_recall){
        int result = recallService.addrecall(product_recall);
        if (result == 1){
            log.info("添加产品召回信息成功！");
        }else {
            log.info("出现问题！");
        }
        return new JsonResult<>(code,OK);
    }

    /**
     * 根据id查询要修改的信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(path = "updaterecall/{id}", method = RequestMethod.GET)
    public String updaterecall(@PathVariable(value = "id") int id, Model model) {
        Product_recall product_recall = recallService.selectByrecall_id(id);
        List<Product> product = recallService.selectproduct();
        model.addAttribute("recall",product_recall);
        model.addAttribute("product",product);
        return "updaterecall";
    }

    /**
     * 保存修改产品召回信息
     * @param product_recall
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saverecall", method= RequestMethod.POST)
    public JsonResult<Void> updaterecall(Product_recall product_recall) {
        int result = recallService.updaterecall(product_recall);
        if (result == 1){
            log.info("修改成功");
        }else {
            log.info("修改失败");
        }
        return new JsonResult<>(code,OK);
    }
    /**
     * 根据产品召回id删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleterecall/{id}", method = RequestMethod.POST)
    public JsonResult<Object> deleteimportant( @PathVariable(value = "id") int id) {
        int result = recallService.deleterecallByid(id);
        if (result ==1){
            log.info("删除成功！");
        }else {
            log.info("删除失败！");
        }
        return new JsonResult<>(code,OK);
    }
}
