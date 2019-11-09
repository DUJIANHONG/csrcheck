package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.Flight_checkException;
import com.csr.csrcheck.util.JsonResult;
import com.csr.csrcheck.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("clinic")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的临床
 */
public class ClinicController extends BaseController{
    @Resource
    private ClinicService clinicService;
    @GetMapping("cliniclist")
    public JsonResult<List<Clinic>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Clinic> list = clinicService.getCliniclist();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     * 根据产品名称分页查询临床
     * @param pageNum
     * @param pageSize
     * @param product_name
     * @return
     */
    @GetMapping("clinic")
    public JsonResult<Object> clinic(@RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "5") int pageSize, String product_name){
        PageResult pageResult=clinicService.getListpage(pageNum,pageSize,product_name);
        log.info("clinic---------------------------->pageNum:"+pageNum);
        log.info("clinic---------------------------->pageSize:"+pageSize);
        log.info("clinic---------------------------->product_name:"+product_name);
        return new JsonResult<>(SUCCESS,OK,pageResult);
    }
}
