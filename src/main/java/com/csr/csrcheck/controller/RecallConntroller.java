package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.pojo.Product_recall;
import com.csr.csrcheck.service.impl.RecallServiceImpl;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 17:50
 */
@Slf4j
@RestController
@RequestMapping("recall")
public class RecallConntroller extends BaseController{
    @Resource
    private RecallServiceImpl recallService;
    @GetMapping("recalllist")
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
}
