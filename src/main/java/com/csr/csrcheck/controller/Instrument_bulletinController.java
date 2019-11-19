package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Abnormal_products;
import com.csr.csrcheck.pojo.Clinic;
import com.csr.csrcheck.pojo.Important_notification;
import com.csr.csrcheck.service.ClinicService;
import com.csr.csrcheck.service.Instrument_bulletinService;
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

@RequestMapping("Instrument_bulletin")
//@Controller
@RestController
@Slf4j

public class Instrument_bulletinController extends BaseController{
    @Resource
    private Instrument_bulletinService instrument_bulletinService;

    /**
     * 查医疗器械中的重要通报
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping("Instrument_bulletinlist")
    public JsonResult<List<Important_notification>> Instrument_bulletinlist(HttpServletResponse response) throws IOException, ServletException {
        List<Important_notification> list = instrument_bulletinService.getImportant_notificationlist();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }

    /**
     * 查医疗器械中的不合格通报
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping("Abnormal_productslist")
    public JsonResult<List<Abnormal_products>> Abnormal_productslist(HttpServletResponse response) throws IOException, ServletException {
        List<Abnormal_products> list = instrument_bulletinService.getAbnormal_productslist();
        if (list==null){
            throw new ClinicException("没有数据");
        }

        return new JsonResult<>(SUCCESS,OK,list);
    }
}
