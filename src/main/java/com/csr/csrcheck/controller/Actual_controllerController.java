package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Actual_controller;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.service.Actual_controllerService;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.Actual_controllerException;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("actual_controller")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的临床
 */
public class Actual_controllerController extends BaseController{
    @Resource
    private Actual_controllerService actual_controllerService;
    @GetMapping("actual_controllerlist")
    public JsonResult<List<Actual_controller>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Actual_controller> list = actual_controllerService.getActual_controllerlist();
        if (list==null){
            throw new Actual_controllerException("核心人员关联企业没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
}
