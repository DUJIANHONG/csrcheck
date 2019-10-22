package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Evaluate;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.EvaluateService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.service.ex.EvaluateException;
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

        return new JsonResult<>(SUCCESS,list);
    }
}
