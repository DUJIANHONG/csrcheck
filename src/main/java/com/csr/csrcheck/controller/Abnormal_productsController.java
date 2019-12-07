package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.impl.Abnormal_productsServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-25 17:20
 */
@Controller
@Slf4j
@RequestMapping("abnormal")
public class Abnormal_productsController extends BaseController{
    @Resource
    private Abnormal_productsServiceImpl abnormal_productsService;
        @RequestMapping("product")
        @ResponseBody
        public JsonResult<List<Abnormal_products>> getAbnormalByTheir_id(){
            List<Abnormal_products> list = abnormal_productsService.getAbnormalByTheir_id(2);
            return new JsonResult<>(code,OK,list);
        }

    /**
     * 跳转到添加页面
      * @param model
     * @return
     */
    @RequestMapping("addabnormal")
        public String selectproduct(Model model){
            List<Product> list = abnormal_productsService.selectproduct();
            model.addAttribute("product",list);
            return "addabnormal";
        }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 保存新增产品异常信息
     * @param abnormal_products
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveaddabnormal", method= RequestMethod.POST)
    public JsonResult<Void> addabnormal(Abnormal_products abnormal_products){
         int result = abnormal_productsService.addabnormal(abnormal_products);
         if (result == 0){
             log.info("添加产品异常信息成功！");
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
    @RequestMapping(path = "updateabnormal/{id}", method = RequestMethod.GET)
    public String updateAbnormal(@PathVariable(value = "id") int id,Model model) {
        Abnormal_products abnormal_products = abnormal_productsService.selectByabnormal_id(id);
        List<Product> product = abnormal_productsService.selectproduct();
        model.addAttribute("abnormal",abnormal_products);
        model.addAttribute("product",product);
        return "updateabnormal";
    }

    /**
     * 保存修改产品信息
     * @param abnormal_products
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveabnormal", method= RequestMethod.POST)
    public JsonResult<Void> updateabnormal(Abnormal_products abnormal_products){
        int result = abnormal_productsService.updateabnormal(abnormal_products);
        if (result == 1){
            log.info("修改成功");
        }else {
            log.info("修改失败");
        }
        return new JsonResult<>(code,OK);
    }
    /**
     * 根据产品id删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleteabnormal/{id}", method = RequestMethod.POST)
    public JsonResult<Object> deleteAbnormal( @PathVariable(value = "id") int id) {
        int result = abnormal_productsService.deleteabnormalByid(id);
        if (result ==1){
            log.info("删除成功！");
        }else {
            log.info("删除失败！");
        }
        return new JsonResult<>(code,OK);
    }
}
