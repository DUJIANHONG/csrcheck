package com.csr.csrcheck.csrhtcontroller;

import com.csr.csrcheck.pojo.*;
import com.csr.csrcheck.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Karry
 * @create 2019-11-16 10:20
 */
@Controller
@RequestMapping("product")
@Slf4j
public class ProductServlet {
    @Resource
    private ProductServiceImpl productService;
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
    @RequestMapping(path = "saveproduct", method = RequestMethod.GET)
    public String addProduct(Product product, @RequestParam("term_of_validity") String date) throws ParseException {
        product.setTerm_of_validity(sdf.parse(date));
        int result= productService.addproduct(product);
        if (result==1){
            log.info("添加成功！");
        }else {
            log.info("添加失败！");
        }
        return "Product";
    }
}
