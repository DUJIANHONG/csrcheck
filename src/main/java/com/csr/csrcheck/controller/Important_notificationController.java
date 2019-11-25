package com.csr.csrcheck.controller;

import com.csr.csrcheck.controller.ex.CompanyException;
import com.csr.csrcheck.service.Important_notificationService;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/9 15:17
 * @version:
 * @modified By:
 */
@RestController
@Slf4j
@RequestMapping("important_notific")
public class Important_notificationController extends BaseController {

    @Resource
    private Important_notificationService important_notificationService;

    /**
     *根据产品名称分页查询重要通报
     *  @param pageNum
     * @param pageSize
     * @param product_name
     * @param product_t_name
     * @return
     */
    @RequestMapping("important")
    public JsonResult<Object> important(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "5") int pageSize,
                                        String product_name, String product_t_name){
        PageResult pageResult=important_notificationService.getimportant_page(pageNum,pageSize,product_name,product_t_name);
        if(pageResult==null){
            throw new CompanyException("数据为空");
        }
        log.info("important----------------------------->pageNum:"+pageNum);
        log.info("important----------------------------->pageSize:"+pageSize);
        log.info("important----------------------------->product_name:"+product_name);
        log.info("important----------------------------->product_t_name:"+product_t_name);
        return new JsonResult<>(code,OK,pageResult);
    }
}
