package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Guide;
import com.csr.csrcheck.service.GuideService;
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
@RequestMapping("guide")
public class GuideConntroller extends BaseController {
    @Resource
    private GuideService guideService;
    @GetMapping("guidelist")
    public JsonResult<List<Guide>> getlistByCompany_id(){
        List<Guide> list = guideService.getGuideList();
        return new JsonResult<>(code,OK,list);
    }

    /**
     *根据药企名称分页查询行业指导药企CSR指南信息
     *  @param pageNum
     * @param pageSize
     * @param company_name
     * @return
     */
    @GetMapping("guide")
    public JsonResult<Object> contend(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      String company_name){
        PageResult pageResult=guideService.getListpage(pageNum,pageSize,company_name);
        log.info("contend---------------------------------->pageNum:"+pageNum);
        log.info("contend---------------------------------->pageSize:"+pageSize);
        log.info("contend---------------------------------->company_name:"+company_name);
        return new JsonResult<>(code,OK,pageResult);
    }
}
