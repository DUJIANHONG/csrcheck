package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Company;
import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.pojo.Product;
import com.csr.csrcheck.service.CompanyService;
import com.csr.csrcheck.service.EvaluateService;
import com.csr.csrcheck.service.ProductService;
import com.csr.csrcheck.service.ex.CompanyException;
import com.csr.csrcheck.service.ex.EvaluateException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("evaluate")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的一致性评价
 */
public class EvaluateController extends BaseController{
    @Resource
    private EvaluateService evaluateService;
    @GetMapping("evaluatelist")
    public JsonResult<List<Evaluate>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Evaluate> list = evaluateService.getEvaluatelist();
        if (list==null){
            throw new EvaluateException("一致性评价没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }


    /**
     * 根据企业名称或者产品名称查询一致性评价信息
     * @param pageNum
     * @param pageSize
     * @param company_name
     * @param product_name
     * @return
     */
    @GetMapping("evaluate")
    public JsonResult<Object> evaluate(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "5") int pageSize,
                                       @RequestParam(value = "cname",required = false) String company_name,
                                       @RequestParam(value = "pname",required = false) String product_name) {
        PageResult pageResult=evaluateService.getlistpage(pageNum,pageSize,company_name,product_name);
        log.info("evaluate--------------------------->pageNum:"+pageNum);
        log.info("evaluate--------------------------->pageSize:"+pageSize);
        log.info("evaluate--------------------------->company_name:"+company_name);
        log.info("evaluate--------------------------->product_name:"+product_name);
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }

    /**
     *增加一致性评价
     *  @param evaluate
     * @return
     */
    @RequestMapping(path = "addEvaluate",method = RequestMethod.POST)
    public JsonResult<Void> addEvaluate(Evaluate evaluate){
        evaluateService.addevlaute(evaluate);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     *修改一致性评价
     *  @param evaluate
     * @return
     */
    @RequestMapping(path = "uppdateEvaluate",method = RequestMethod.POST)
    public JsonResult<Void> uppdateEvaluate(Evaluate evaluate){
        evaluateService.updateevlaute(evaluate);
        return new JsonResult<>(SUCCESS,OK);
    }
    /**
     *删除一致性评价
     *  @param id
     * @return
     */
    @RequestMapping(path = "deleteEvaluate/{id}",method = RequestMethod.POST)
    public JsonResult<Void> deleteEvaluate(@PathVariable(value = "id") int id){
        evaluateService.deleteevlaute(id);
        return new JsonResult<>(SUCCESS,OK);
    }

    /**
     * 根据id查找一致性评价
     * @param id
     * @return
     */
    @RequestMapping(path = "findEvaluate/{id}",method = RequestMethod.POST)
    public JsonResult<Evaluate> findEvaluate(@PathVariable(value = "id") int id){
        Evaluate evaluate=evaluateService.findevluateByid(id);
        if(evaluate==null){
            throw new CompanyException("没有数据");
        }
        return new JsonResult<>(SUCCESS,OK,evaluate);
    }
    @Resource
    private CompanyService companyService;

    /**
     *下拉框展示企业数据
     *  @return
     */
    @RequestMapping(path = "showcompany",method = RequestMethod.POST)
    public JsonResult<List<Company>> showcompany(){
        List<Company> list = companyService.getCommpanylist();
        return new JsonResult<>(SUCCESS,OK,list);
    }
    @Resource
    private ProductService productService;

    /**
     * 下拉框展示产品数据
     * @return
     */
    @RequestMapping(path="listproduct", method= RequestMethod.POST)
    public JsonResult<List<Product>> listproduct(){
        List list=productService.list();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
