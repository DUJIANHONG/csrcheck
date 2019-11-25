package com.csr.csrcheck.controller;
import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/31 13:58
 * @version:
 * @modified By:
 */
@Controller
@RequestMapping("product")
@Slf4j
public class ProductController extends BaseController {

    @Resource
    private ProductService productService;

    /**
     *分页查询产品
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    @RequestMapping("productpage")
    public JsonResult<Object> productpage(@RequestParam(defaultValue = "1") int pageNum,
                                                 @RequestParam(defaultValue = "5") int pageSize,
                                                 String product_name){
        PageResult pageResult=productService.listpage(pageNum,pageSize,product_name);
        if(pageResult==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(code,OK,pageResult);
    }

    public String selectproduct_type(Model model){
        List<Product_type> list = productService.selectProduct_type();
        return "/";
    }

    /**
     * 跳转到新增产品页面
     */
    @RequestMapping("addproduct")
    public String addproduct(Model model){
        List<Company> company = productService.selectCompany();
        List<Product_type> typelist = productService.selectProduct_type();
        List<Patent_type> patent = productService.selectPatent();
        List<Stage> stages = productService.selectStage();
        model.addAttribute("company",company);
        model.addAttribute("typelist",typelist);
        model.addAttribute("patent",patent);
        model.addAttribute("stages",stages);
        return "addproduct";
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 新增成功后跳转到产品列表
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "saveproduct", method = RequestMethod.POST)
    public JsonResult<Object> addProduct(Product product, @RequestParam("term_of_validity") String date) throws ParseException {
        product.setTerm_of_validity(sdf.parse(date));
        int result = productService.addproduct(product);
        if (result ==1){
            log.info("添加成功！");
        }else {
            log.info("添加失败！");
        }
        return new JsonResult<>(SUCCESS,OK);
    }



    @RequestMapping(path = "updateproduct/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable(value = "id") int id,Model model) {
        Product product = productService.selectByproduct_id(id);
        List<Company> company = productService.selectCompany();
        List<Product_type> typelist = productService.selectProduct_type();
        List<Patent_type> patent = productService.selectPatent();
        List<Stage> stages = productService.selectStage();
        model.addAttribute("company",company);
        model.addAttribute("typelist",typelist);
        model.addAttribute("patent",patent);
        model.addAttribute("stages",stages);
        model.addAttribute("product",product);
        return "updateproduct";
    }

    /**
     * 保存修改产品信息
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(path="saveupdateproduct", method= RequestMethod.POST)
    public JsonResult<Void> updateproduct(Product product){
        try {
            int result = productService.updateProduct(product);
            if (result == 1) {
                log.info("修改了产品信息！");
            } else {
                log.info("未完成修改！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     * 根据产品id删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleteproduct/{id}", method = RequestMethod.POST)
    public JsonResult<Object> deleteProduct(Product product, @PathVariable(value = "id") int id) {
        int result = productService.deleteProductByid(id);
        if (result ==1){
            log.info("删除成功！");
        }else {
            log.info("删除失败！");
        }
        return new JsonResult<>(SUCCESS,OK);
    }
}
