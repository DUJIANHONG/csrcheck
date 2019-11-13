package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Exponent;
import com.csr.csrcheck.pojo.Industry;
import com.csr.csrcheck.service.ExponentService;
import com.csr.csrcheck.service.IndustryService;
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
 * @create 2019-10-22 14:05
 */
@Slf4j
@RestController
@RequestMapping("exponent")
public class ExponentConntroller extends BaseController {
    @Resource
    private ExponentService exponentService;
    @GetMapping("exponentlist")
    public JsonResult<List<Exponent>> getlistByCompany_id(){
        List<Exponent> list = exponentService.getExponentList();
        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     *根据药企名称分页查询指数发布
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @GetMapping("exponent")
    public JsonResult<Object> contend(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      String company_name){
        PageResult pageResult=exponentService.getListpage(pageNum,pageSize,company_name);
        log.info("contend---------------------------------->pageNum:"+pageNum);
        log.info("contend---------------------------------->pageSize:"+pageSize);
        log.info("contend---------------------------------->company_name:"+company_name);
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }
}
