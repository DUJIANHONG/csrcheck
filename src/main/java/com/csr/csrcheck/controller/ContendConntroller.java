package com.csr.csrcheck.controller;

import com.csr.csrcheck.pojo.Contend;
import com.csr.csrcheck.pojo.Patent;
import com.csr.csrcheck.service.ContendService;
import com.csr.csrcheck.service.impl.PatentSerciceImpl;
import com.csr.csrcheck.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Karry
 * @create 2019-10-22 14:05
 */
@RestController
@RequestMapping("contend")
public class ContendConntroller extends BaseController {
    @Resource
    private ContendService contendService;
    @GetMapping("contendlist")
    public JsonResult<List<Contend>> getlistByCompany_id(){
        List<Contend> list = contendService.getContendList();
        return new JsonResult<>(SUCCESS,OK,list);
    }
}
