package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Other;
import com.csr.csrcheck.service.OtherService;
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
@RequestMapping("other")
public class OtherConntroller extends BaseController {
    @Resource
    private OtherService otherService;
    @GetMapping("otherlist")
    public JsonResult<List<Other>> getlistByCompany_id(){
        List<Other> list = otherService.getOtherList();
        return new JsonResult<>(code,OK,list);
    }

    /**
     *根据药企名称分页查询药企其他信息
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @GetMapping("other")
    public JsonResult<Object> contend(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      String company_name){
        PageResult pageResult=otherService.getListpage(pageNum,pageSize,company_name);
        log.info("contend---------------------------------->pageNum:"+pageNum);
        log.info("contend---------------------------------->pageSize:"+pageSize);
        log.info("contend---------------------------------->company_name:"+company_name);
        return new JsonResult<>(code,OK,pageResult);
    }
}
