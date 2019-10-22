package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Flight_check;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.IFlight_checkService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.Flight_checkException;
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

        return new JsonResult<>(SUCCESS,list);
    }
}
