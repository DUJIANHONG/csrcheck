package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Approvals;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.service.ApprovalsService;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.ex.ClinicException;
import com.csr.csrcheck.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.AppletIOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("approvals")
//@Controller
@RestController
@Slf4j
/**
 * 查药企中的批文
 */
public class ApprovalsController extends BaseController{
    @Resource
    private ApprovalsService approvalsService;
    @GetMapping("approvalslist")
    public JsonResult<List<Approvals>> Flight_checklist(HttpServletResponse response) throws IOException, ServletException {
        List<Approvals> list = approvalsService.getApprovalslist();
        if (list==null){
            throw new AppletIOException("批文没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
}
